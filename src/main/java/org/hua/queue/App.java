package org.hua.queue;

/* imports */
import java.util.Iterator;

/* main class, displays basic use of the dequeues primary functions */
public class App {

    public static void main (String[] args) throws InterruptedException {

        DeQueue<Integer> deQueue = new DoubleEndedQueue<>();
        System.out.print("Starting Stage DeQueue: ");
        Iterator<Integer> iterator = deQueue.iterator();

        while (iterator.hasNext()) {
            Integer element = iterator.next();
            System.out.print(element + " ");
        }
        /* pushes 12 elements from 0 to 11 at the start of the array */
        for (int i = 0; i < 12; i++) {
            deQueue.pushFirst(i);
        }
        System.out.println();
        System.out.print("DeQueue after Pushing 12 elements: ");
        iterator = deQueue.iterator();

        /* accesses & prints every element one by one (11 to 0) */
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            System.out.print(element + " ");
        }
        System.out.println();

        /* pops the first 8 elements */
        for (int i = 0; i < 8; i++) {
            deQueue.popFirst();
        }
        System.out.print("DeQueue after Popping 8 elements: ");
        iterator = deQueue.iterator();

        /* accesses & prints every element one by one (3 to 0) */
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            System.out.print(element + " ");
        }
        System.out.println();

        System.out.print("Iterator: ");
        iterator = deQueue.iterator();

        /* accesses & prints the elements in ascending order */
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            System.out.print(element + " ");
        }
        System.out.println();

        System.out.print("Descending Iterator: ");
        Iterator<Integer> descendingIterator = deQueue.descendingIterator();

        /* accesses & prints the elements in descending order */
        while (descendingIterator.hasNext()) {
            Integer element = descendingIterator.next();
            System.out.print(element + " ");
        }
        System.out.println();

        System.out.println("First: " + deQueue.first()); /* prints the first element */
        System.out.println("Last: " + deQueue.last()); /* prints the last element */
        System.out.println("Size: " + deQueue.size()); /* displays the array's size */
        System.out.println("Empty: " + deQueue.isEmpty()); /* displays whether the dequeue is empty or not */
        System.out.println("Clearing array...");

        Thread.sleep(3000); /* sleeps for 3 sec */

        deQueue.clear(); /* empties the dequeue of its elements */

        System.out.println("Size: " + deQueue.size()); /* displays the array's size */
        System.out.println("Empty: " + deQueue.isEmpty()); /* displays whether the dequeue is empty or not */

    }
}
