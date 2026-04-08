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

        if(head == null){
            // Node temp = null;
            return null;
        }
        Node head2 = head;
        Node curr = new Node(head.val);
        Node prev = curr;
        
        while(head2 != null){
            if(head2.next != null)
                curr.next = new Node(head2.next.val);
            else
                curr.next = null;
            curr = curr.next;
            head2 = head2.next;
        }

        // printList(prev);
        curr = prev;
        head2 = head;
        Node random = null;


        while(curr != null){
            random = traverse(prev, head2);
            curr.random = random;
            head2 = head2.next;
            curr = curr.next;
        }

        return prev;
    }

    public Node traverse(Node curr, Node head2){

        if(head2.random == null){
            while(curr != null)
                curr = curr.next;
            return curr;
        }

        while((curr.val != head2.random.val) && curr != null){
            curr = curr.next;
        }
        return curr;
    }

    public void printList(Node curr){
        while(curr != null){
            System.out.println(curr.val + " -> ");
            curr = curr.next;
        }
    }
}
