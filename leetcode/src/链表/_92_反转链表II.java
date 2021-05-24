package 链表;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * 
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 
 * @author yuehuig
 *
 */
public class _92_反转链表II {
	
	public ListNode reverseBetween(ListNode head, int left, int right) {
		if (head == null || head.next == null || left == right) {
			return head;
		}
		ListNode dummyNode = new ListNode(-1, head);
		
		ListNode pre = dummyNode;
		for (int i = 0; i < left - 1; i++) {
			pre = pre.next;
		}
		
		ListNode rightNode = pre;
		for (int i = left; i <= right; i++) {
			rightNode = rightNode.next;
		}
		
		ListNode leftNode = pre.next;
		ListNode succ = rightNode.next;
		
		pre.next = null;
		rightNode.next = null;
		reverseLinkedList(leftNode);
		pre.next = rightNode;
		leftNode.next = succ;
		return dummyNode.next;
	}
	
	/// 反转链表
	private static void reverseLinkedList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		
		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
	}
	
	
	public ListNode reverseBetween1(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
			return head;
		}
		
		ListNode leftNode = head;
		ListNode cur = head;
		int index = 0;
		Stack<ListNode> stack = new Stack<ListNode>();
		while (cur != null) {
			index++;
			if (index < left) {
				leftNode = cur;
				cur = cur.next;
			} else if (index == left) {
				stack.push(cur);
				cur = cur.next;
			} else if (index < right) {
				stack.push(cur);
				cur = cur.next;
			} else if (index == right) {
				stack.push(cur);
				cur = cur.next;
			} else {
				break;
			}
		}

        if (left == 1) {
            head = stack.pop();
            leftNode = head;
        }

		while (stack.isEmpty() == false) {
			leftNode.next = stack.pop();
			leftNode = leftNode.next;
		}
		leftNode.next = cur;
		return head;
    }
}
