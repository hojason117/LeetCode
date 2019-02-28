/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode chop = dummy, pointer = dummy;
        
        for(int i = 0; i < n; i++)
            pointer = pointer.next;
        
        while(pointer.next != null) {
            chop = chop.next;
            pointer = pointer.next;
        }
        
        chop.next = chop.next.next;
        
        return dummy.next;
    }
}
