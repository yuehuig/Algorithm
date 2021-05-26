package 链表;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/reorder-list/
 * 
 * @author yuehuig
 *
 */
public class _143_重排链表 {
	
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		Stack<ListNode> stack = new Stack<ListNode>();
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		while (slow != null) {
			stack.push(slow);
            slow = slow.next;
		}
		
		ListNode cur = head;
		while (stack.isEmpty() == false) {
			ListNode temp = cur.next;
			cur.next = stack.pop();
			cur.next.next = temp;
			cur = cur.next.next;
		}
        cur.next = null;
    }
}
