package 链表;

public class _83_删除排序链表中的重复元素 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = new ListNode(-1, head);
		ListNode curNode = newHead;
		while (curNode.next != null && curNode.next.next != null) {
			while (curNode.next.next != null && (curNode.next.val == curNode.next.next.val)) {
				curNode.next = curNode.next.next;
			}
			curNode = curNode.next;
		}
		return newHead.next;
    }

	public ListNode deleteDuplicates1(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode curNode = head;
		ListNode nextNode = head.next;
		while (nextNode != null) {
			if (curNode.val == nextNode.val) {
				nextNode = nextNode.next;
				curNode.next = nextNode;
			} else {
				curNode = nextNode;
				nextNode = nextNode.next;
			}
		}
		return head;
	}
}
