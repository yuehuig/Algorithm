package 链表;

import java.util.Stack;

/**
 *  输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 */
public class _剑指Offer_06_从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int size = stack.size();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = stack.pop().val;
        }
        return arr;
    }
}
