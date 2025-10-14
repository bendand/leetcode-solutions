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
    public void reorderList(ListNode head) {
        // initialize slow and fast pointers to find midpoint of list
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // gets second half of the nodes of our linked list
        ListNode second = slow.next;
        // point node at slow pointer to null, breaking the linked list
        slow.next = null;
        // initialize prev to null, a crucial component of linked list reversed
        ListNode prev = null;

        // reverse the second half of the linked list
        while (second != null) {
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        // first half of our linked list, and second half is reversed at this point
        ListNode first = head;
        second = prev;

        // second half might be shorter, so use second being null as the exit condition
        while (second != null) {
            // save our next nodes in both lists
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            // first points to reversed half node, second points to next node in first half
            first.next = second;
            second.next = tmp1;
            // first and second halves are updated
            first = tmp1;
            second = tmp2;
        }
    }
}