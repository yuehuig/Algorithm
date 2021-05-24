package com.yuehuig.union;

public class UnionFind_QU_PC extends UnionFind_QU {

	public UnionFind_QU_PC(int capacity) {
		super(capacity);
	}
	
	public int find(int v) {
		rangeCheck(v);
		if (parents[v] != v) {
			parents[v] = find(parents[v]);
		}
		return parents[v];
	}
	
}
