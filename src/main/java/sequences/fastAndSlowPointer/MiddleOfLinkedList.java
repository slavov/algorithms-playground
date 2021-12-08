package sequences.fastAndSlowPointer;

/**
 * Given the head of a Singly LinkedList, write a method to return the middle node of the
 * LinkedList.
 *
 * <p>If the total number of nodes in the LinkedList is even, return the second middle node.
 *
 * <p>Example 1:
 *
 * <p>Input: 1 -> 2 -> 3 -> 4 -> 5 -> null Output: 3 Example 2:
 *
 * <p>Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null Output: 4 Example 3:
 *
 * <p>Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null Output: 4
 *
 * <p>LeetCode: <a href="https://leetcode.com/problems/middle-of-the-linked-list/">876. Middle of
 * the Linked List</a>
 */
public class MiddleOfLinkedList<T> {

    /** Time complexity O(n) Space complexity O(1) */
    public ListNode<T> middleNode(ListNode<T> head) {
        ListNode<T> slow = head;
        ListNode<T> fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
