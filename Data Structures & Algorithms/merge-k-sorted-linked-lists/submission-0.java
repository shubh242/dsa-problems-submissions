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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }

        ListNode head = lists[0];
        for(int i = 1; i < lists.length; i++){
            head = addList(head, lists[i]);
        }

        return head;
    }

    public ListNode addList(ListNode head, ListNode merge){
        ListNode curr = new ListNode(0);
        ListNode prev = curr;

        while(head != null && merge != null){
            if(head.val <= merge.val){
                curr.next = head;
                head = head.next;
            }else{
                curr.next = merge;
                merge = merge.next;
            }
            curr = curr.next;
        }

        if(head != null){
            curr.next = head;
        }

        if(merge != null){
            curr.next = merge;
        }

        return prev.next;
    }
}
