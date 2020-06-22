package com.yuehuig;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(123);
		
		System.out.println("*******************");
		System.out.println(fib2(10));
		System.out.println(fib3(10));
	}

	public static int fib1(int n) {
		if (n <= 1) {
			return n;
		}
		return fib1(n - 2) + fib1(n - 1);
	}

	/// 0 1 1 2 3 5 8
	public static int fib2(int n) {
		if (n <= 1) {
			return n;
		}
		
		int first = 0;
		int second = 1;
		for (int i = 0; i < n - 1; i++) {
			int current = first + second;
			first = second;
			second = current;
		}
		
		return second;
	}
	
	public static int fib3(int n) {
		if (n <= 1) {
			return n;
		}
		
		int first = 0;
		int second = 1;
		for (int i = 0; i < n - 1; i++) {
			second = first + second;
			first = second - first;
		}
		
		return second;
	}
}
