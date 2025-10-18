/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/


class Solution {
    public Node copyRandomList(Node head) {
        // hashmap that stores copies of nodes in original head
        Map<Node, Node> oldToCopy = new HashMap<>();
        // putting null here simplifies access of null references
        oldToCopy.put(null, null);

        // cur iterates through our list, keeping head intact
        Node cur = head;
        // create copies of each node in head
        while (cur != null) {
            Node copy = new Node(cur.val);
            oldToCopy.put(cur, copy);
            cur = cur.next;
        }

        // reset cur before making second pass
        cur = head;
        // create next and random references for node copies
        while (cur != null) {
            Node copy = oldToCopy.get(cur);
            copy.next = oldToCopy.get(cur.next);
            copy.random = oldToCopy.get(cur.random);
            cur = cur.next;
        }

        return oldToCopy.get(head);
    }
}