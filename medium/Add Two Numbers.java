/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        boolean carry = false;
        while(l1 != null || l2 != null) {
            int v1 = 0, v2 = 0;
            
            if(l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }
            
            if(carry) {
                current.next = new ListNode((v1 + v2 + 1) % 10);
                if(v1 + v2 + 1 < 10)
                    carry = false;   
            }
            else {
                current.next = new ListNode((v1 + v2) % 10);
                if(v1 + v2 >= 10)
                    carry = true;
            }
            
            current = current.next;
        }
        
        if(carry)
            current.next = new ListNode(1);
        
        return result.next;
    }
}
