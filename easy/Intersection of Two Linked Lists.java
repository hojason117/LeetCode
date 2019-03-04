/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// calculate the length
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointerA = headA, pointerB = headB;
        int lengthA = 0, lengthB = 0;
        while(pointerA != null) {
            pointerA = pointerA.next;
            lengthA++;
        }
        while(pointerB != null) {
            pointerB = pointerB.next;
            lengthB++;
        }
        
        if(pointerA != pointerB)
            return null;
        
        ListNode longer = (lengthA >= lengthB) ? headA : headB;
        ListNode shorter = (lengthA < lengthB) ? headA : headB;
        int diff = Math.abs(lengthA - lengthB);
        
        for(int i = 0; i < diff; i++)
            longer = longer.next;
        
        while(shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }
        
        return shorter;
    }
}

// two pointers walk same distance
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointerA = headA, pointerB = headB;
        while(pointerA != pointerB) {
            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }
        
        return pointerA;
    }
}
