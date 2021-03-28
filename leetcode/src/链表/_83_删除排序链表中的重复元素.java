package 链表;

public class _83_删除排序链表中的重复元素 {
	public ListNode deleteDuplicates(ListNode head) {
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
