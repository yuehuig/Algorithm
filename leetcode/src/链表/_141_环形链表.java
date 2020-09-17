package 链表;

public class _141_环形链表 {
	
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		
		ListNode slowNode = head;
		ListNode fastNode = head.next;
		while (fastNode != null && fastNode.next != null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
			
			if (slowNode == fastNode) {
				return true;
			}
		}
        return false;
    }
}
