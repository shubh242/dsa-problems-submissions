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
    public boolean hasCycle(ListNode head) {
        Set<ListNode> next = new HashSet<>();

        while(head != null){
            if(next.contains(head)){
                return true;
            }
            next.add(head);
            head = head.next;
        }
        return false;
    }
}
