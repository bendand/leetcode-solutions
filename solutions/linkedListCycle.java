/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // initialized slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;

        // while loop conditions ensure fast.next.next doesn't throw null pointer exception
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // if both references to nodes match, we have a cycle
            if (slow == fast) {
                return true;
            }

        }

        return false;
    }
}