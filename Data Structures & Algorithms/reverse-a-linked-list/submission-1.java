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
        List<Integer> ll = new ArrayList<>();
        ListNode reverseHead = new ListNode();

        if(head == null)
            return head;
        
        while(head != null){
            ll.add(head.val);
            head = head.next;
        }

        ListNode start = new ListNode();
        
        // System.out.println(ll.toString());
        
        if(ll.size() > 0){
            reverseHead.val = ll.get(ll.size()-1);
            if(ll.size() != 1)
                reverseHead.next = start;
        }

        for(int i = ll.size()-2; i >= 0; i--){
            start.val = ll.get(i);
            if(i != 0){
                start.next = new ListNode();
                start = start.next;
            }
        }

        return reverseHead;
    }
}
