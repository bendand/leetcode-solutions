/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // dummy node from which we attach the head of the list
        ListNode dummy = new ListNode(0, head);
        // pointer that stops before node to remove
        ListNode left = dummy;
        // pointer jumps ahead n nodes, trailing behind it our unbroken tail of nodes
        ListNode right = head;

        // right jumps ahead n nodes
        while (n > 0) {
            right = right.next;
            n--;
        }

        // left and right move until right pointer is null
        while (right != null) {
            left = left.next;
            right = right.next;
        }

        // attach left pointer to node after subsequent node in initial sequence and return new list
        left.next = left.next.next;
        return dummy.next;
    }
}