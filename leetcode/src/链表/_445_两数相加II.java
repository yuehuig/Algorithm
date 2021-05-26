package 链表;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 
 * @author yuehuig
 *
 */
public class _445_两数相加II {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}
		
		LinkedList<ListNode> stack1 = new LinkedList<ListNode>();
		LinkedList<ListNode> stack2 = new LinkedList<ListNode>();
		while (l1 != null) {
			stack1.push(l1);
			l1 = l1.next;
		}
		
		while (l2 != null) {
			stack2.push(l2);
			l2 = l2.next;
		}
		
		int carry = 0;
		ListNode ans = null;
		while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
			int m = stack1.isEmpty() ? 0 : stack1.pop().val;
			int n = stack2.isEmpty() ? 0 : stack2.pop().val;
			
			int temp = m + n + carry;
			int cur = temp % 10;
			carry = temp / 10;
			
			ListNode curNode = new ListNode(cur, ans);
			ans = curNode;
		}
		return ans;
    }
}
