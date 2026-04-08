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
        ListNode temp = head;
        ListNode swap;
        ListNode reorder;
        int n = 0;
        int counter = 1;

        while(temp != null){
            n++;
            temp = temp.next;
        }
        System.out.println(n);

        temp = head;

        while(counter <= n/2){
            System.out.println(temp.val + " " + counter);
            swap = temp.next;
            temp.next = getLink(temp, counter, n);
            System.out.println("SWAP " + swap.val);
            System.out.println("NEXT " + temp.next.val);
            temp.next.next = swap;
            temp = swap;
            System.out.println(temp.val);
            counter++;
        }
        temp.next = null;
    }

    public ListNode getLink(ListNode temp, int tracker, int n){
        int i = n-tracker;
        while(tracker <= i){
            temp = temp.next;
            tracker++;
        }
        // System.out.println(temp.val);
        return temp;
    }
}
