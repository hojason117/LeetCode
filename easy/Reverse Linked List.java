public class Solution {
	public ListNode reverseList(ListNode head) {
		if(head == null)
			return null;
		
		ListNode temp1;
		ListNode temp2 = head;
		head = null;
		
		while(temp2 != null) {
			temp1 = temp2.next;
			temp2.next = head;
			head = temp2;
			temp2 = temp1;
		}
		
		return head;
	}
}