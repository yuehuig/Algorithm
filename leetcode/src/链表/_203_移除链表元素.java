package 链表;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 
 * @author yuehuig
 *
 */
public class _203_移除链表元素 {
	
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return head;
		}
		ListNode dummpyHead = new ListNode(-1, head);
		ListNode curr = dummpyHead;
		while (curr.next != null) {
			if (curr.next.val == val) {
				curr.next = curr.next.next;
			} else {
                curr = curr.next;
            }
		}
		return dummpyHead.next;
    }
}
