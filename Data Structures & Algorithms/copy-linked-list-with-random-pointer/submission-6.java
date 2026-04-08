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
        Map<Node, Node> copy = new HashMap<>();
        Node curr = head;

        while(curr != null){
            Node copied = new Node(curr.val);
            copy.put(curr, copied);
            curr = curr.next;
        }

        curr = head;
        Node copied;
        while(curr != null){
            copied = copy.get(curr);
            copied.next = copy.get(curr.next);
            copied.random = copy.get(curr.random);
            copied = copied.next;
            curr = curr.next;
        }
        return copy.get(head);
    }
}
