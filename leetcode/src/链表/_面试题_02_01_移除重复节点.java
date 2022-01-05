package 链表;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 */
public class _面试题_02_01_移除重复节点 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curNode = dummyNode;
        Set<Integer> set = new HashSet();
        while (curNode != null && curNode.next != null) {
            if (set.add(curNode.next.val)) {
                curNode = curNode.next;
            } else {
                curNode.next = curNode.next.next;
            }
        }
        return dummyNode.next;
    }
}
