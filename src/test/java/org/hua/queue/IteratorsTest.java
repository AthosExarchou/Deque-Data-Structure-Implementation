package org.hua.queue;

/* imports */
import org.junit.Test;
import java.util.Iterator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/* this test checks whether both iterators work properly */
public class IteratorsTest {

    DeQueue<Integer> deQueue = new DoubleEndedQueue<>();

    @Test
    public void IteratorsTest() {

        assertTrue(deQueue.isEmpty());
        assertEquals(0, deQueue.size());

        for (int i = 1; i <= 5; i++) {
            deQueue.pushLast(i);
        }
        assertEquals(5, deQueue.size());
        assertEquals("1 2 3 4 5 ", iteratorOutput(deQueue.iterator()));
        assertEquals("5 4 3 2 1 ", iteratorOutput(deQueue.descendingIterator()));
    }

    private String iteratorOutput(Iterator<Integer> iterator) {

        StringBuilder res = new StringBuilder();

        while (iterator.hasNext()) {
            res.append(iterator.next()).append(" ");
        }
        return res.toString();
    }
}
