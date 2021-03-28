package 链表;

public class _1290_二进制链表转整数 {
	// 反转链表 
	public int getDecimalValue(ListNode head) {
		if (head == null || head.next == null) return head.val;

        ListNode newHead = null;
		while (head != null) {
			ListNode tempNode = head.next;
			head.next = newHead;
			newHead = head;
			head = tempNode;
		}

		int a = 1;
		int num = 0;
		while (newHead != null) {
			num += newHead.val * a;
			a = a << 1;
            newHead = newHead.next;
		}
		return num;
    }
	//                     (1 * 2^2 + 0 * 2^1 + 1 * 2^0) + 下一位 ->  (1 * 2^2 + 0 * 2^1 + 1 * 2^0) * 2 + 下一位
	//                                                                (1 * 2^3 + 0 * 2^2 + 1 * 2^1 + 0 * 2^0) + 下一位
	// 每乘以2 相当于左移以为2进制位数进1 + 二进制最后一位 101 -> 1010 + 下一位  ->  = 
	public int getDecimalValue2(ListNode head) {
		ListNode curNode = head;
		int result = 0;
		while (curNode != null) {
			result = (result * 2) + curNode.val;
			curNode = curNode.next;
		}
		return result;
    }
}
