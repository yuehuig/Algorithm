package 链表;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * @author yuehuig
 *
 */
public class _206_反转链表 {
	
	/// 递归实现
	/// https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/solution/shi-pin-jiang-jie-die-dai-he-di-gui-hen-w2gm0/
	public ListNode reverseList(ListNode head) {
		// 假如链表中有 5 》 4 》 3 》 2 》 1   如果传进去是 4 则返回 4 《 3 《 2 《 1 这个反转的链表
		// reverseList(head.next) 返回的newHead  尾部是head.next   把之前的head连起来就反转好了
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode newHead = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
    }
	
	/// 非递归实现 头插法
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
	
	/// 非递归实现 原地反转
	public ListNode reverseList3(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode next = head.next;
		head.next = null;
		while (next != null) {
			ListNode tempNode = next.next;
			next.next = head;
			head = next;
			next = tempNode;
		}
		return head;
	}
}
