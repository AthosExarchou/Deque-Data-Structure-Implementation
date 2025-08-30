package org.hua.queue;

/* imports */
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/* tests that the halving and doubling of the array's capacity operates correctly */
public class ResizingDeQueueTest {

    DeQueue<Integer> deQueue = new DoubleEndedQueue<>();

    @Test
    public void ResizingDeQueueTest() {

        assertTrue(deQueue.isEmpty());
        assertEquals(0, deQueue.size());

        for (int i = 1; i <= 7; i++) {
            deQueue.pushLast(i);
        }
        assertEquals(7, deQueue.size());
        deQueue.pushLast(8); /* triggers doubleCapacity */
        assertEquals(8, deQueue.size());

        for (int i = 1; i <= 4; i++) {
            deQueue.popLast(); /* triggers halfCapacity */
        }
        assertEquals(4, deQueue.size());
    }
}
