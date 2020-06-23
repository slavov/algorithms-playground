package sequences.reversalLinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sequences.fastAndSlowPointer.ListNode;

class RotateLinkedListTest {

    private RotateLinkedList instance;
    private ListNode head;

    @BeforeEach
    void setUp() {
        instance = new RotateLinkedList();
        head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(4);
        head.next.next.next.next = new ListNode<>(5);
        head.next.next.next.next.next = new ListNode(6);

    }

    @Test
    void rotateTest() {
        ListNode rotated = instance.rotateRight(head, 3);
        assertEquals(4, rotated.val);
        assertEquals(5, rotated.next.val);
        assertEquals(6, rotated.next.next.val);
    }

}
