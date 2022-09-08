package leetcode.fast_and_slow_pointer;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * <p>You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * <p>Example 1:
 *
 * <p>Given 1->2->3->4, reorder it to 1->4->2->3. Example 2:
 *
 * <p>Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 *
 * <p>LeetCode: <a href="https://leetcode.com/problems/reorder-list/">143. Reorder List</a>
 */
public class ReorderList<T> {

    /** Time complexity O(n) Space complexity O(1) */
    public void reorderList(ListNode<T> head) {
        var middle = findMid(head);
        var reversed = reverse(middle);
        var trav = head;
        while (trav != null && reversed.next != null) {
            var next = trav.next;
            var revNext = reversed.next;

            trav.next = reversed;
            if (next != null) reversed.next = next;

            trav = next;
            reversed = revNext;
        }
    }

    private ListNode<T> findMid(ListNode<T> head) {
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode<T> reverse(ListNode<T> node) {
        ListNode<T> prev = null;
        while (node != null) {
            ListNode<T> next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
