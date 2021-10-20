package 链表;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 */
public class _24_两两交换链表中的节点 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1, head);
        ListNode curNode = dummyNode;
        while (curNode.next != null && curNode.next.next != null) {
            ListNode tempNode = curNode.next.next.next;
            ListNode eNode = curNode.next;
            curNode.next = curNode.next.next;
            curNode.next.next = eNode;
            eNode.next = tempNode;
            curNode = curNode.next.next;
        }
        return dummyNode.next;
    }
}
