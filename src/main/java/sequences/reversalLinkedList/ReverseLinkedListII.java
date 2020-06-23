package sequences.reversalLinkedList;

import sequences.fastAndSlowPointer.ListNode;

/**
 * Reverse a singly linked list.
 * <p>
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * <p>
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * <p>
 * LeetCode: <a href="https://leetcode.com/problems/reverse-linked-list-ii/">92. Reverse Linked List II</a>
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        var cur = head;
        ListNode prev = null;

        // after skipping 'm-1' nodes, current will point to 'm'th node
        for (int i = 0; cur != null && i < m - 1; i++) {
            prev = cur;
            cur = cur.next;
        }
        // we are interested in three parts of the LinkedList:
        // 1. part before index 'm',
        // 2. part between 'm' and 'n',
        // 3. and the part after index 'n'
        ListNode firstPart = prev; // points to the node at index 'm-1'
        // after reversing the LinkedList 'current' will become the last node of the sub-list
        ListNode subList = cur;
        // reverse nodes between 'm' and 'n'
        for (int i = 0; cur != null && i < n - m + 1; i++) {
            var next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        // connect with the first part
        if (firstPart != null) {
            firstPart.next = prev; // 'previous' is now the first node of the sub-list
        } else { // this means p == 1 i.e., we are changing the first node (head) of the LinkedList
            head = prev;
        }
        // connect with the last part
        subList.next = cur;
        return head;
    }
}
