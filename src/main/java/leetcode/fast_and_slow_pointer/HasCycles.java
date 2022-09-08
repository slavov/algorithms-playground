package leetcode.fast_and_slow_pointer;

/**
 * Given a linked list, determine if it has a cycle in it. LeetCode: <a
 * href="https://leetcode.com/problems/linked-list-cycle/">Linked list cycle</a>
 */
public class HasCycles<T> {

    /** Time complexity O(n) Space complexity O(1) */
    public boolean hasCycle(ListNode<T> head) {
        ListNode<T> slow = head;
        ListNode<T> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
