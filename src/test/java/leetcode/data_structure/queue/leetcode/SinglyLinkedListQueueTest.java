package leetcode.data_structure.queue.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SinglyLinkedListQueueTest {

    private SinglyLinkedListQueue instance = new SinglyLinkedListQueue(3);

    @Test
    void singlyListTestCase() {
        assertTrue(instance.enQueue(1));
        assertTrue(instance.enQueue(2));
        assertTrue(instance.enQueue(3));
        assertFalse(instance.enQueue(4));
        assertEquals(3, instance.rear());
        assertTrue(instance.isFull());
        assertTrue(instance.deQueue());
        assertTrue(instance.enQueue(4));
        assertEquals(4, instance.rear());
        assertEquals(2, instance.front());
    }
}
