package sequences.reversalLinkedList;

import sequences.fastAndSlowPointer.ListNode;

/**
 * Given the head of a Singly LinkedList and a number ‘k’, rotate the LinkedList to the right by ‘k’ nodes.
 * <p>
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * <p>
 * LeetCode: <a href="https://leetcode.com/problems/rotate-list/">61. Rotate List</a>
 */
public class RotateLinkedList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k < 1) {
            return head;
        }
        var lastNode = head;
        var listSize = 1;

        while (lastNode.next != null) {
            lastNode = lastNode.next;
            listSize++;
        }

        lastNode.next = head;   // connect the last node with the head to make it a circular list
        k = k % listSize;       // no need to do rotations more than the length of the list

        int skipLength = listSize - k;
        var lastNodeOfRotatedList = head;

        for (int i = 0; i < skipLength - 1; i++) {
            lastNodeOfRotatedList = lastNodeOfRotatedList.next;
        }

        // 'lastNodeOfRotatedList.next' is pointing to the sub-list of 'k' ending nodes
        head = lastNodeOfRotatedList.next;
        lastNodeOfRotatedList.next = null;

        return head;
    }

}
