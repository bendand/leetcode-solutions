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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // dummy node to which we attach our sorted tail of nodes
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        // while we have nodes in list1 and list2
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                // attaching our smaller list1 value to tail
                tail.next = list1;
                // move list1 forward
                list1 = list1.next;
            } else {
                // attaching our smaller or equal list2 value to tail
                tail.next = list2;
                // move list2 forward
                list2 = list2.next;
            }
            // update the pointer of our tail of nodes
            tail = tail.next;
        }

        // one list of nodes is inevitably left after our while loop, and attach to tail
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        // return dummy.next, which will contain the beginning of our sorted linked list
        return dummy.next;
    }
}