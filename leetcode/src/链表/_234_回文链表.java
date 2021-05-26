package 链表;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * 请判断一个链表是否为回文链表。
 * 
 * @author yuehuig
 *
 */
public class _234_回文链表 {
	
	public boolean isPalindrome(ListNode head) {
		if (head == null) {
			return false;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		int i = 0;
		int size = list.size() - 1;
		while (i < size) {
			if (list.get(i++) != list.get(size--)) {
				return false;
			}
		}
		return true;
	}
	
	
	// 栈
	public boolean isPalindrome1(ListNode head) {
		if (head == null) {
			return false;
		}
		
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode cur = head;
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		
		while (head != null) {
			if (head.val == stack.pop().val) {
				head = head.next;
			} else {
				return false;
			}
		}
		return true;
    }
}
