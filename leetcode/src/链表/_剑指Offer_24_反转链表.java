package 链表;

/**
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * @author yuehuig
 *
 */

public class _剑指Offer_24_反转链表 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode dummyNode = null;
        ListNode curNode = head;

        while (curNode != null) {
            ListNode tempNode = curNode.next;
            curNode.next = dummyNode;
            dummyNode = curNode;
            curNode = tempNode;
        }
        return dummyNode;
    }
}
