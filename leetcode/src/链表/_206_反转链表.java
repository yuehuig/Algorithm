package 链表;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @author yuehuig
 *
 */
public class _206_反转链表 {
	
	/// 递归实现
	public ListNode reverseList(ListNode head) {
		// 假如链表中有 5 》 4 》 3 》 2 》 1   如果传进去是 4 则返回 4 《 3 《 2 《 1 这个反转的链表
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode newHead = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
    }
	
	/// 非递归实现
	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null) return head;
		
		ListNode newHead = null;
		while (head != null) {
			ListNode tempNode = head.next;
			head.next = newHead;
			newHead = head;
			head = tempNode;
		}
		return newHead;
    }
}
