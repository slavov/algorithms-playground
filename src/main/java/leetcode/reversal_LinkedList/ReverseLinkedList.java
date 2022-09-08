package leetcode.reversal_LinkedList;

import leetcode.fast_and_slow_pointer.ListNode;

/**
 * Reverse a singly linked list.
 *
 * <p>Example: Input: 1->2->3->4->5->NULL Output: 5->4->3->2->1->NULL
 *
 * <p>Follow up: A linked list can be reversed either iteratively or recursively. Could you
 * implement both?
 *
 * <p>LeetCode: <a href="https://leetcode.com/problems/reverse-linked-list/">206. Reverse Linked
 * List</a>
 */
public class ReverseLinkedList<T> {

    public ListNode<T> reverseList(ListNode<T> head) {
        ListNode<T> prev = null;
        var trav = head;
        while (trav != null) {
            var nextTmp = trav.next;
            trav.next = prev;
            prev = trav;
            trav = nextTmp;
        }
        return prev;
    }

    public ListNode<T> reverseListRecursively(ListNode<T> head) {
        if (head == null || head.next == null) {
            return head;
        }
        var result = reverseListRecursively(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }
}
