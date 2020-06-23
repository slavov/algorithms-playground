package sequences.reversalLinkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import sequences.fastAndSlowPointer.ListNode;

class ReverseEveryKElementsTest {

    private ReverseEveryKElements solution = new ReverseEveryKElements();

    @Test
    void success() {
        //given
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        //when
        var result = solution.reverse(head, 2);

        //then
        assertEquals(2, result.val);
        assertEquals(1, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(4, result.next.next.next.val);
    }

}
