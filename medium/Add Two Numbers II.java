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
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        ListNode pointer = null;
        boolean carry = false;
        while(!s1.isEmpty() || !s2.isEmpty()) {
            int temp = carry ? 1 : 0;
            temp += s1.isEmpty() ? 0 : s1.pop();
            temp += s2.isEmpty() ? 0 : s2.pop();
            carry = (temp / 10 == 1);
            ListNode newNode = new ListNode(temp % 10);
            newNode.next = pointer;
            pointer = newNode;
        }
        
        if(carry) {
            ListNode newNode = new ListNode(1);
            newNode.next = pointer;
            pointer = newNode;
        }
        
        return pointer;
    }
}
