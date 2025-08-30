package org.hua.queue;

/* imports */
import java.util.Iterator;

public interface DeQueue<E> {
    /**
     * Push a new element at the front of the queue
     *
     * @param elem the element
     */
    void pushFirst(E elem);
    /**
     * Push a new element at the end of the queue
     *
     * @param elem the element
     */
    void pushLast(E elem);
    /**
     * Pop an element from the front of the queue
     */
    E popFirst();
    /**
     * Pop an element from the end of the queue
     */
    E popLast();
    /**
     1
     * Return the first element of the queue
     *
     * @return the first element of the queue
     */
    E first();
    /**
     * Return the last element of the queue
     *
     * @return the last element of the queue
     */
    E last();
    /**
     * Check if a queue is empty
     *
     * @return true if empty, false otherwise
     */
    boolean isEmpty();
    /**
     * Get the size of the queue
     *
     * @return the size of the queue
     */
    int size();
    /**
     * Clear the queue
     */
    void clear();
    /**
     * Returns an iterator over the elements of the queue
     */
    Iterator<E> iterator();
    /**
     * Returns an iterator over the elements of the queue in reverse
     * sequential order.
     */
    Iterator<E> descendingIterator();
}
