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
    public ListNode reverseList(ListNode head) {
        // curr pointer to keep head of linked list intact
        ListNode curr = head;
        // previous list node, updated to keep track of previous references to reassign pointers
        ListNode prev = null;

        while (curr != null) {
            // captures next node so we dont lose it when reassigning our pointers 
            ListNode temp = curr.next;
            // reassign pointer 
            curr.next = prev;
            // update previous node to current node so we can reassign next node
            prev = curr;
            // update curr with next node in sequence
            curr = temp;
        }

        // return prev, which contains our reversed linked list
        return prev;
    }
}