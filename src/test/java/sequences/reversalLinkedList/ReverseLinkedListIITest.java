package sequences.reversalLinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import sequences.fastAndSlowPointer.ListNode;

class ReverseLinkedListIITest {

    private ReverseLinkedListII solution = new ReverseLinkedListII();

    @Test
    void success() {
        // given
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // when
        ListNode result = solution.reverseBetween(head, 2, 4);
        assertEquals(4, result.next.val);
    }
}
