package 链表;
/*
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/dong-hua-tu-jie-leetcode-di-19-hao-wen-ti-shan-chu/
 */
public class _19_删除链表的倒数第N个结点 {
	/**
	 * 我们可以设想假设设定了双指针 p 和 q 的话，当 q 指向末尾的 NULL，p 与 q 之间相隔的元素个数为 n 时，那么删除掉 p 的下一个指针就完成了要求。
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n <= 0) {
			return head;
		}
		ListNode dummyNode = new ListNode(-1, head);
		ListNode slowNode = dummyNode;
		ListNode fastNode = head;
		for (int i = 0; i < n; i++) {
			fastNode = fastNode.next;
		}
		while (fastNode != null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next;
		}
		slowNode.next = slowNode.next.next;
		return dummyNode.next;
    }
}
