package com.yuehuig;

public class LinkedList<E> extends AbstractList<E> {
	
	private Node<E> first;
	
	
	private static class Node<E> {
		E element;
		Node<E> next;
		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}
	}


	@Override
	public void clear() {
		size = 0;
		first = null;
	}

	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		
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
		if (size == 0) {
			first = new Node<E>(element, first);
		}
		Node<E> prev = node(index - 1);
		Node<E> node = new Node<E>(element, prev.next);
		prev.next = node;
		size++;
	}
	
	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int indexOf(E element) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private Node<E> node(int index) {
		rangeCheck(index);
		Node<E> node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
}
