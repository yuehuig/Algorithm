package 链表;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * https://leetcode-cn.com/problems/linked-list-cycle-ii 
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * 
 * 说明：不允许修改给定的链表。
 * 
 * @author yuehuig
 *
 */
public class _142_环形链表II {
	
	public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
        	return null;
        }
        
        Set<ListNode> set = new HashSet<ListNode>();
        while (head != null) {
			if (set.contains(head)) {
				return head;
			} else {
				set.add(head);
			}
			head = head.next;
		}

        return null;
    }
	
	public ListNode detectCycle1(ListNode head) {
//		slow * 2 = fast;
//		slow = a + b;
//		fast = a + b + c + b = a + 2*b + c;
//		(a + b)*2 = a + 2*b + c;
//		a = c;
		
//		快针走的是慢针的两倍。
//		慢针走过的路，快针走过一遍。
//		快针走过的剩余路程，也就是和慢针走过的全部路程相等。(a+b = c+b)
//		刨去快针追赶慢针的半圈(b)，剩余路程即为所求入环距离(a=c)
			
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
			if (fast == null && fast.next == null) {
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
        
        fast = head;
        while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
        return slow;
    }
}
