package 链表;

/**
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * @author yuehuig
 *
 */
public class _109_有序链表转换二叉搜索树 {
	public TreeNode sortedListToBST(ListNode head) {
		return buildTree(head, null);
    }
	
	private TreeNode buildTree(ListNode left, ListNode right) {
		if (left == right) {
			return null;
		}
		ListNode mid = getMid(left, right);
		TreeNode root = new TreeNode(mid.val);
		root.left = buildTree(left, mid);
		root.right = buildTree(mid.next, right);
		return root;
	}
	
	/// 获取中位
	private ListNode getMid(ListNode left, ListNode right) {
		ListNode slow = left;
		ListNode fast = left;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
}
