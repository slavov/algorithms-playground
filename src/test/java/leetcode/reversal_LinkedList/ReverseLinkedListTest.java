package leetcode.reversal_LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import leetcode.fast_and_slow_pointer.ListNode;

class ReverseLinkedListTest {

    private ReverseLinkedList<Integer> data = new ReverseLinkedList<>();
    private ListNode<Integer> head;

    @BeforeEach
    void setUp() {
        int[] output = new int[] {1, 2, 3, 4, 5};

        head = toListNode(output);
    }

    @Test
    void reverseList() {
        var result = data.reverseList(head);
        assertEquals(5, result.val);
    }

    @Test
    void reverseListRecursively() {
        assertEquals(5, data.reverseListRecursively(head).val);
    }

    private ListNode<Integer> toListNode(int[] output) {
        ListNode<Integer> dummyRoot = new ListNode<>(0);
        var ptr = dummyRoot;
        for (int item : output) {
            ptr.next = new ListNode<>(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
}
