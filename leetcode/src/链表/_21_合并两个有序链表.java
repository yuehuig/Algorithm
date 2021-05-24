package 链表;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * @author yuehuig
 *
 */
public class _21_合并两个有序链表 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
			return null;
		}
		
		ListNode newHead = new ListNode(-1);
		ListNode cur = newHead;
		while (l1 != null && l2 != null) {
			int minVal = l1.val;
			if (l2.val < l1.val) {
				minVal = l2.val;
				l2 = l2.next;
			} else {
				l1 = l1.next;
			}

			cur.next = new ListNode(minVal);
			cur = cur.next;
		}
		
		if (l1 == null) {
			cur.next = l2;
		} else {
			cur.next = l1;
		}
	
		return newHead.next;
    }
	
	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }
        ListNode newHead = new ListNode(l1.val < l2.val ? l1.val : l2.val);
        ListNode next = newHead;
        while ((l1 != null) && (l2 != null)) {
            if (l1.val < l2.val) {
                next.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                next.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            next = next.next;
        }

        next.next = l1 == null ? l2 : l1;
        newHead = newHead.next;
        return newHead;
    }
}
