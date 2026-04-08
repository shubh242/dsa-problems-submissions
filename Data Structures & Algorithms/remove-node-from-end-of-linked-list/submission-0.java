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
        int size = 0;
        ListNode curr = head;

        while(curr != null){
            size++;
            curr = curr.next;
        }

        ListNode prev = null;
        curr = head;
        int counter = 0;

        while(curr != null){
            if(counter == (size-n) && (size-n) >= 1){
                prev.next = curr.next;
            }else if(counter == (size-n) && (size-n) < 1){
                return curr.next;
            }else{
                prev = curr;
            }
            curr = curr.next;
            counter++;
        }
        return head;
    }
}
