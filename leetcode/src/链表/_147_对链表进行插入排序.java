package 链表;

/**
 * https://leetcode-cn.com/problems/insertion-sort-list/
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 */
public class _147_对链表进行插入排序 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
//        dummyNode.next = head;
//        ListNode lastSorted = head;
//        ListNode curNode = head.next;
//        while (curNode != null) {
//            if (curNode.val > lastSorted.val) {
//                lastSorted.next = curNode;
//                lastSorted = curNode;
//                curNode = curNode.next;
//            } else {
//                ListNode prev = dummyNode;
//                while (prev.next.val <= curNode.val) {
//                    prev = prev.next;
//                }
//                lastSorted.next = curNode.next;
//                prev.next = curNode;
//            }
//        }
        return dummyNode.next;
    }
}
