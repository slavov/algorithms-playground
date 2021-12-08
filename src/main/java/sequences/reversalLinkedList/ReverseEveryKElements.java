package sequences.reversalLinkedList;

import sequences.fastAndSlowPointer.ListNode;

/**
 * Given the head of a LinkedList and a number ‘k’, reverse every alternating ‘k’ sized sub-list
 * starting from the head.
 *
 * <p>If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.
 *
 * <p>Educative: <a
 * href="https://www.educative.io/courses/grokking-the-coding-interview/m2YYJJRP9KG">Reverse
 * alternating K-element Sub-list (medium)</a>
 */
public class ReverseEveryKElements {

    public ListNode reverse(ListNode head, int k) {
        ListNode cur = head, prev = null;
        while (cur != null) {
            ListNode subList = cur;
            ListNode previouse = prev;

            for (int i = 0; i < k && cur != null; i++) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }

            if (previouse != null) {
                previouse.next = prev;
            } else {
                head = prev;
            }

            subList.next = cur;
            prev = subList;

            for (int i = 0; i < k && cur != null; i++) {
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
