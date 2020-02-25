package sequences.fastAndSlowPointer;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * LeetCode: <a href="https://leetcode.com/problems/linked-list-cycle-ii/">Linked list cycle II</a>
 */
public class DetectCycles {

    /**
     * Time complexity O(n)
     * Space complexity O(1)
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode slow2 = head;
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
