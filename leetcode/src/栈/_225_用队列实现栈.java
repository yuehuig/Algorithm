package 栈;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 *
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 *
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *
 */
public class _225_用队列实现栈 {
}

class MyStack {

    Queue<Integer> inQueue = new LinkedList();
    Queue<Integer> outQueue = new LinkedList();
    public MyStack() {

    }

    public void push(int x) {
        outQueue.offer(x);
        while(inQueue.isEmpty() == false) {
            outQueue.offer(inQueue.poll());
        }
        // swip(inQueue, outQueue);
        Queue temp = inQueue;
        inQueue = outQueue;
        outQueue = temp;
    }

    public int pop() {
        return inQueue.poll();
    }

    public int top() {
        return inQueue.peek();
    }

    public boolean empty() {
        return inQueue.isEmpty();
    }

    private void swip(Queue q1, Queue q2) {
        Queue temp = q1;
        q1 = q2;
        q2 = temp;
    }
}