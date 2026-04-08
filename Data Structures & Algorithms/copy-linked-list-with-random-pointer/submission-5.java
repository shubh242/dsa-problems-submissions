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
        if(head == null)
            return null;
        Node temp = head;
        Node curr = new Node(head.val);
        Node prev = curr;

        while(head != null){
            if(head.next != null){
                curr.next = new Node(head.next.val);
            }else{
                curr.next = null;
            }
            curr = curr.next;
            head = head.next;
        }

        head = temp;
        curr = prev;
        Node random = null;

        while(curr != null){
            random = traverse(temp, head, prev);
            curr.random = random;
            head = head.next;
            curr = curr.next;
        }
        return prev;
    }

    public Node traverse(Node temp, Node head, Node curr){

        if(head.random == null){
            while(curr != null){
                curr = curr.next;
            }
            return curr;
        }

        while(temp != head.random){
            temp = temp.next;
            curr = curr.next;
        }
        return curr;
    }
}
