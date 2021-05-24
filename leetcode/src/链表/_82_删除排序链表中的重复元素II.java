package 链表;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * 
 * 返回同样按升序排列的结果链表。
 * @author yuehuig
 *
 */
public class _82_删除排序链表中的重复元素II {
	
	public ListNode deleteDuplicates(ListNode head) {
        while (head == null || head.next == null) {
			return head;
		}
		
		ListNode dummyHead = new ListNode(0, head);
		ListNode cur = dummyHead;
		while (cur.next != null && cur.next.next != null) {
			if (cur.next.val == cur.next.next.val) {
				int x = cur.next.val;
				while (cur.next != null && cur.next.val == x) {
					cur.next = cur.next.next;
				}
			} else {
				cur = cur.next;
			}
		}
		
		return dummyHead.next;
    }
}
