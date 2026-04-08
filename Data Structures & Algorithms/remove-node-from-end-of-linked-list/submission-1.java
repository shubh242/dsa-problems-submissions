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
        Map<Integer, ListNode> nodeMap = new HashMap<>();

        while(curr != null){
            nodeMap.put(size, curr);
            size++;
            curr = curr.next;
        }
        if(size == n)
            return head.next;

        curr = head;
        int i = 0;
        while(i < size-n-1){
            curr = curr.next;
            i++;
        }
        // if(curr.next == null)
        curr.next = curr.next.next;
        curr = curr.next;
        return head;
    }
}
