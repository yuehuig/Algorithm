package 链表;

/**
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 */
public class _剑指Offer_22_链表中倒数第k个节点 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }

        ListNode slowNode = head, fastNode = head;
        for (int i = 0; i < k; i++) {
            fastNode = fastNode.next;
        }

        while (fastNode != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        return slowNode;
    }
}
