package org.hua.queue;

/* imports */
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* class that implements the methods of the DeQueue interface */
public class DoubleEndedQueue<E> implements DeQueue<E> {

    /* variable declaration */
    public static final int INITIAL_CAPACITY = 8;
    private E[] array;
    private int f, r;
    private transient int modCount = 0;

    @SuppressWarnings("unchecked")
    /* constructor of dequeue */
    public DoubleEndedQueue() {

        this.array = (E[]) new Object[INITIAL_CAPACITY];
        this.f = 0;
        this.r = 0;
    }

    @Override
    /* inserts an element into the start of the array */
    public void pushFirst (E elem) {

        if (size() == array.length - 1)
            doubleCapacity();

        f = (f - 1 + array.length) % array.length;
        array[f] = elem;
        modCount++;
    }

    @Override
    /* inserts an element into the end of the array */
    public void pushLast (E elem) {

        if (size() == array.length - 1)
            doubleCapacity();

        array[r] = elem;
        r = (r + 1) % array.length;
        modCount++;
    }

    @Override
    /* deletes the array's first element */
    public E popFirst() {

        if (isEmpty())
            throw new NoSuchElementException("Array is empty, hence cannot pop element.");

        E first = array[f];
        array[f] = null;
        f = (f + 1) % array.length;

        if (size() > 0 && (4 * size() <= array.length))
            halfCapacity();

        modCount++;
        return first;
    }

    @Override
    /* deletes the array's last element */
    public E popLast() {

        if (isEmpty())
            throw new NoSuchElementException("Array is empty, hence cannot pop element.");

        r = (r - 1 + array.length) % array.length;
        E last = array[r];
        array[r] = null;

        if (size() > 0 && (4 * size() <= array.length))
            halfCapacity();

        modCount++;
        return last;
    }

    @Override
    /* returns the array's first element */
    public E first() {

        if (isEmpty())
            throw new NoSuchElementException("Array is empty, hence first element does not exist.");

        return array[f];
    }

    @Override
    /* returns the array's last element */
    public E last() {

        if (isEmpty())
            throw new NoSuchElementException("Array is empty, hence last element does not exist.");

        return array[(r - 1 + array.length) % array.length];
    }

    @Override
    /* returns whether the array is empty or not */
    public boolean isEmpty() {
        return f == r;
    }

    @Override
    /* returns the array's size */
    public int size() {
        return (r - f + array.length) % array.length;
    }

    @SuppressWarnings("unchecked")
    @Override
    /* resets the array */
    public void clear() {

        this.array = (E[]) new Object[INITIAL_CAPACITY];
        this.f = 0;
        this.r = 0;
        modCount++;
    }

    @Override
    public Iterator<E> iterator() {
        return new DeQueueIterator();
    }

    @Override
    public Iterator<E> descendingIterator() {
        return new DescendingDeQueueIterator();
    }

    /* accesses array's elements and returns them from f to r-1 */
    private class DeQueueIterator implements Iterator<E> {

        /* variable declaration */
        private int cur;
        private int expectedModCount = modCount;

        public DeQueueIterator() {
            cur = f;
        }

        @Override
        public boolean hasNext() {
            return cur != r;
        }

        @Override
        public E next() {

            checkForComodification();

            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = array[cur];
            cur = (cur + 1) % array.length;
            return result;
        }
        /* ensures that the modification counter's value is as it should be */
        final void checkForComodification() {

            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();

        }
    }

    /* accesses array's elements and returns them from r-1 to f */
    private class DescendingDeQueueIterator implements Iterator<E> {

        /* variable declaration */
        private int cur;
        private int expectedModCount = modCount;

        public DescendingDeQueueIterator() {
            cur = (r - 1 + array.length) % array.length;
        }

        @Override
        public boolean hasNext() {
            return cur  != ((f - 1 + array.length) % array.length);
        }

        @Override
        public E next() {

            checkForComodification();

            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = array[cur];
            cur = (cur - 1 + array.length) % array.length;
            return result;
        }

        /* ensures that the modification counter's value is as it should be */
        final void checkForComodification() {

            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();

        }
    }

    @SuppressWarnings("unchecked")
    /* doubles the array's capacity in the case that either pushFirst or pushLast are called and
       the element to be added would have rendered the array full */
    private void doubleCapacity() {

        int newCapacity = 2 * array.length;
        int size = size();
        E[] newArray = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newArray[i] = array[(f + i) % array.length];
        }
        array = newArray;
        f = 0;
        r = size;
    }

    @SuppressWarnings("unchecked")
    /* halfCapacity has been constructed in such a way as to not allow the
       array's length to go below the INITIAL_CAPACITY (8 in this case) */
    private void halfCapacity() {

        if (array.length <= INITIAL_CAPACITY) {
            return;
        }
        int newCapacity = array.length / 2;
        int size = size();
        assert size <= newCapacity; /* ensures that 'size <= newCapacity' is indeed true */
        E[] newArray = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newArray[i] = array[(f + i) % array.length];
        }
        array = newArray;
        f = 0;
        r = size;
    }

}
