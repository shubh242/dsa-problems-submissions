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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode num1 = new ListNode();
        ListNode num2 = num1;

        int i = 0, l = 0, r = 0, carry = 0, sum = 0;

        while(l1 != null || l2 != null || carry != 0){
            l = (l1 != null) ? l1.val: 0;
            r = (l2 != null) ? l2.val: 0;
            sum = l + r + carry;
            carry = sum/10;
            
            num2.next = new ListNode(sum%10);
            num2 = num2.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        
        return num1.next;
    }
}
