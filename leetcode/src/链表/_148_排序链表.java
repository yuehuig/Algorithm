package 链表;

/**
 * https://leetcode-cn.com/problems/sort-list/
 * 
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 
 * 
 * @author yuehuig
 *
 */
public class _148_排序链表 {
	
	/// 归并
	public ListNode sortList(ListNode head) {
		return sortList(head, null);
    }
	
	public ListNode sortList(ListNode head, ListNode tail) {
		if (head == null) {
			return head;
		}
		
		if (head.next == tail) {
			head.next = null;
			return head;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		while (fast != tail && fast.next != tail) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode mid = slow;
		ListNode left = sortList(head, mid);
		ListNode right = sortList(mid, tail);
		ListNode sorted = merge(left, right);
		return sorted;
	}
	
	public ListNode merge(ListNode left, ListNode right) {
		ListNode dummyNode = new ListNode(-1);
		ListNode temp = dummyNode;
		ListNode leftHead = left;
		ListNode rightHead = right;
		while (leftHead != null && rightHead != null) {
			if (leftHead.val <= rightHead.val) {
				temp.next = leftHead;
				leftHead = leftHead.next;
			} else {
				temp.next = rightHead;
				rightHead = rightHead.next;
			}
			temp = temp.next;
		}
		
		if (leftHead != null) {
			temp.next = leftHead;
		} else {
			temp.next = rightHead;
		}
		return dummyNode.next;
	}
}
