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
    public void reorderList(ListNode head) {
        int size = 0;
        Map<Integer, ListNode> orderMap = new HashMap<>();
        ListNode curr = head;
        while(curr != null){
            orderMap.put(size, curr);
            size++;
            curr = curr.next;
        }
        curr = head;
        int i = 0;
        while(i != size/2){
            ListNode temp = curr.next;
            ListNode reordered = orderMap.get(size-i-1);
            curr.next = reordered;
            curr.next.next = temp;
            curr = temp;
            i++;
        }
        curr.next = null;
    }
}
