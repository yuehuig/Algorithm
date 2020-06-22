package com.yuehuig;

public class Main {
	
	public static void main(String[] args) {
		int array[] = new int[] {11, 22, 33};
		System.out.println(array.toString());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.remove(3);
		list.set(1, 5);
		System.out.println(list);
	}

}
