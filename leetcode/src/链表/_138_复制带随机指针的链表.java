package 链表;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 * @author yuehuig
 *
 */

class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class _138_复制带随机指针的链表 {
	
	HashMap<RandomNode, RandomNode> hashMap = new HashMap<RandomNode, RandomNode>();
	public RandomNode copyRandomList(RandomNode head) {
		if (head == null) {
			return head;
		}
		
        if (this.hashMap.containsKey(head)) {
        	return this.hashMap.get(head);
        }
        
        RandomNode nNode = new RandomNode(head.val);
        this.hashMap.put(head, nNode);
        
        nNode.next = this.copyRandomList(head.next);
        nNode.random = this.copyRandomList(head.random);
        
        return nNode;
    }
}