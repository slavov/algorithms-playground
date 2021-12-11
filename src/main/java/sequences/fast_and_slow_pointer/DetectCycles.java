package sequences.fast_and_slow_pointer;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * LeetCode: <a href="https://leetcode.com/problems/linked-list-cycle-ii/">Linked list cycle II</a>
 */
public class DetectCycles<T> {

    /** Time complexity O(n) Space complexity O(1) */
    public ListNode<T> detectCycle(ListNode<T> head) {
        ListNode<T> slow = head;
        ListNode<T> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode<T> slow2 = head;
                while (slow2 != slow) {
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
