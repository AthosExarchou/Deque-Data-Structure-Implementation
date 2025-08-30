package org.hua.queue;

/* imports */
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/* this test is primarily based on the LinkedQueueTest of Lab2 of the Data Structures course */
public class DeQueueTest {

    DeQueue<Integer> deQueue = new DoubleEndedQueue<>();

    @Test
    public void DeQueueTest() {

        assertTrue(deQueue.isEmpty());
        int count = 100000;

        for (int i = 0; i < count; i++) {

            deQueue.pushFirst(i);
            assertTrue(deQueue.size() == i + 1);
        }
        int current = 0;

        while (!deQueue.isEmpty()) {

            assertTrue(deQueue.last() == current);
            assertTrue(deQueue.popLast() == current);
            current++;
        }
        assertTrue(deQueue.isEmpty());
    }
}
