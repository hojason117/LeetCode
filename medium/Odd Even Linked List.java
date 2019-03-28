/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
            
        ListNode odd = head, even = head.next;
        ListNode oddPointer = odd, evenPointer = even;
        
        while(true) {
            if(evenPointer.next == null)
                break;
            else if(evenPointer.next.next == null) {
                oddPointer.next = evenPointer.next;
                oddPointer = oddPointer.next;
                evenPointer.next = null;
                break;
            }
            else {
                ListNode temp = evenPointer.next;
                evenPointer.next = temp.next;
                oddPointer.next = temp;
                evenPointer = evenPointer.next;
                oddPointer = oddPointer.next;
            }
        }
        
        oddPointer.next = even;
        
        return odd;
    }
}
