package 链表;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/solution/kuai-man-zhi-zhen-zhu-yao-zai-yu-diao-shi-by-liwei/ 
 * @author yuehuig
 *
 */
public class _876_链表的中间结点 {
	// 注意链表为奇数和偶数的情况
	public ListNode middleNode(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slowNode = head;
		ListNode fastNode = head;
		while (fastNode != null && fastNode.next != null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
		}
		return slowNode;
    }
}
