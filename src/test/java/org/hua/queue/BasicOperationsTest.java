package org.hua.queue;

/* imports */
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/* tests whether the basic functions of the dequeue operate correctly */
public class BasicOperationsTest {

    DeQueue<String> deQueue = new DoubleEndedQueue<>();

    @Test
    public void BasicOperationsTest() {

        assertTrue(deQueue.isEmpty());
        assertEquals(0, deQueue.size());

        deQueue.pushFirst("A");
        deQueue.pushLast("B");
        deQueue.pushFirst("C");
        deQueue.pushLast("D");

        assertEquals("C", deQueue.first());
        assertEquals("D", deQueue.last());
        assertEquals("C", deQueue.popFirst());
        assertEquals("D", deQueue.popLast());
        assertEquals("A", deQueue.first());
        assertEquals("B", deQueue.last());

        deQueue.popFirst();
        deQueue.popLast();

        assertTrue(deQueue.isEmpty());
        assertEquals(0, deQueue.size());

        deQueue.pushFirst("E");
        deQueue.pushLast("F");

        assertEquals(2, deQueue.size());

        deQueue.clear();

        assertTrue(deQueue.isEmpty());
        assertEquals(0, deQueue.size());
    }
}
