/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Recursively 1
class Solution {
    public ListNode reverseList(ListNode head) {
        return helper(null, head);
    }
    
    private ListNode helper(ListNode previous, ListNode current) {
        if(current == null)
            return previous;
        
        ListNode temp = current.next;
        current.next = previous;
        previous = current;
        current = temp;
        
        return helper(previous, current);
    }
}

// Recursively 2
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode reversed = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        
        return reversed;
    }
}

// Iteratively
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pointer = head;
        ListNode previous = null;
        while(pointer != null) {
            ListNode temp = pointer.next;
            pointer.next = previous;
            previous = pointer;
            pointer = temp;
        }
        
        return previous;
    }
}
