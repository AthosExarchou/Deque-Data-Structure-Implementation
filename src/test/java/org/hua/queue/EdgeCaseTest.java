package org.hua.queue;

/* imports */
import org.junit.Test;
import java.util.NoSuchElementException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/* 'EdgeCaseTest' tests the worst-case scenarios. In other words, it tests the program's exception handling abilities. */
public class EdgeCaseTest {

    DeQueue<String> deQueue = new DoubleEndedQueue<>();

    @Test
    public void EdgeCaseTest() {

        assertTrue(deQueue.isEmpty());
        assertEquals(0, deQueue.size());

        try {
            deQueue.popFirst();
        } catch (NoSuchElementException e) {
            assertEquals("Array is empty, hence cannot pop element.", e.getMessage());
        }

        try {
            deQueue.popLast();
        } catch (NoSuchElementException e) {
            assertEquals("Array is empty, hence cannot pop element.", e.getMessage());
        }

        try {
            deQueue.first();
        } catch (NoSuchElementException e) {
            assertEquals("Array is empty, hence first element does not exist.", e.getMessage());
        }

        try {
            deQueue.last();
        } catch (NoSuchElementException e) {
            assertEquals("Array is empty, hence last element does not exist.", e.getMessage());
        }
    }
}
