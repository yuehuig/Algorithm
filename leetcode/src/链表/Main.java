package 链表;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_206_反转链表 linkList = new _206_反转链表();
		
		ListNode node0 = new ListNode(0);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node0.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		System.out.printf("list %d - %d - %d - %d - %d %n", node0.val, node0.next.val, node0.next.next.val, node0.next.next.next.val, node0.next.next.next.next.val);
		
//		ListNode newHead = linkList.reverseList(node0);
		ListNode newHead = linkList.reverseList2(node0);
		System.out.printf("list %d - %d - %d - %d - %d %n", newHead.val, newHead.next.val, newHead.next.next.val, newHead.next.next.next.val, newHead.next.next.next.next.val);
	}

}
