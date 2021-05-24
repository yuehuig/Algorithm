package 链表;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @author yuehuig
 *
 */
public class _2_两数相加 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode pre = new ListNode(0);
		ListNode cur = pre;
		int carry = 0; // 进位
		while (l1 != null || l2 != null) {
			int x = l1 != null ? l1.val : 0;
			int y = l2 != null ? l2.val : 0;
			int sum = x + y + carry;
			
			carry = sum / 10;
			sum = sum % 10;
			cur.next = new ListNode(sum);
			cur = cur.next;
			
			if (l1 != null) {
				l1 = l1.next;
			}
			
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		
		if (carry == 1) {
			cur.next = new ListNode(carry);
		}
		return pre.next;
    }
}
