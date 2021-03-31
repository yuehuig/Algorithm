package 链表;
/**
 * 相交链表
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/jiao-ni-yong-lang-man-de-fang-shi-zhao-dao-liang-2/
 * @author yuehuig
 *
 */
public class _160_相交链表 {

	/*
	 *  一种比较巧妙的方式是，分别为链表A和链表B设置指针A和指针B，然后开始遍历链表，如果遍历完当前链表，则将指针指向另外一个链表的头部继续遍历，直至两个指针相遇。
		最终两个指针分别走过的路径为：
		指针A :a+c+b
		指针B :b+c+a
		明显 a+c+b = b+c+a,因而如果两个链表相交，则指针A和指针B必定在C结点相遇
		若不相交，a +b = b+a 。因此相遇处是NULL
		这一方法的时间复杂度为o(m+n),其中m和n分别为两个指针的长度，空间复杂度为o(1)。
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode pA = headA;
		ListNode pB = headB;
		while (pA != pB) {
			pA = pA == null ? headB : pA.next;
			pB = pB == null ? headA : pB.next; 
		}
		return pA;
    }
}
