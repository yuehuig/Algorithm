package com.yuehuig;

import com.yuehuig.AbstractList;

public abstract class LinkedList<E> extends AbstractList<E> {
	
	private Node<E> first;
	private Node<E> last;
	
	private static class Node<E> {
		Node<E> prev;
		E element;
		Node<E> next;
		public Node(Node<E> prev, E element, Node<E> next) {
			this.prev = prev;
			this.element = element;
			this.next = next;
		}
	}

	@Override
	public void clear() {
		size = 0;
		first = null;
		last = null;
	}

	@Override
	public E get(int index) {
		return node(index).element;
	}


	@Override
	public E set(int index, E element) {
		Node<E> node = node(index);
		E old = node.element;
		node.element = element;
		return old;
	}

	@Override
	public void add(int index, E element) {
		rangeCheck(index);
		
		if (index == size) {
			Node<E> oldLast = last;
			last = new Node<E>(oldLast, element, null);
			if (oldLast == null) { /// 一个元素也没有
				first = last;
			} else {
				oldLast.next = last;
			}
		} else {
			Node<E> next = node(index);
			Node<E> prev = next.prev;
			Node<E> node = new Node<E>(prev, element, next);
			next.prev = node;
			if (prev == null) {
				first = node;
			} else {
				prev.next = node;
			}
		}
		size++;
	}
	
	@Override
	public E remove(int index) {
		rangeCheck(index);
		
		Node<E> node = node(index);
		Node<E> prev = node.prev;
		Node<E> next = node.next;
		
		if (prev == null) {
			first = prev;
		} else {
			prev.next = next;
		}
		
		if (next == null) {
			last = next;
		} else {
			next.prev = prev;
		}
		
		size--;
		return node.element;
	}


	@Override
	public int indexOf(E element) {
		Node<E> node = first;
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (node.element == null) {
					return i;
				}
				node = node.next;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (node.element.equals(element)) {
					return i;
				}
				node = node.next;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	private Node<E> node(int index) {
		rangeCheck(index);		
		if (index < (size << 1)) {
			Node<E> node = first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		} else {
			Node<E> node = last;
			for (int i = size -1; i > index; i--) {
				node = node.prev;
			}
			return node;
		}
	}
}
