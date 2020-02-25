package sequences.fastAndSlowPointer;

/**
 * Given a linked list, determine if it has a cycle in it.
 * LeetCode: <a href="https://leetcode.com/problems/linked-list-cycle/">Linked list cycle</a>
 */
public class HasCycles {

    /**
     * Time complexity O(n)
     * Space complexity O(1)
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
