/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p1 = l1, p2 = l2, current = result;
        
        while(p1 != null || p2 != null) {
            if(p1 == null) {
                current.next = p2;
                break;
            }
            else if(p2 == null) {
                current.next = p1;
                break;
            }
            else {
                if(p1.val <= p2.val) {
                    current.next = p1;
                    p1 = p1.next;
                }
                else {
                    current.next = p2;
                    p2 = p2.next;
                }
            }
            
            current = current.next;
        }
        
        return result.next;
    }
}
