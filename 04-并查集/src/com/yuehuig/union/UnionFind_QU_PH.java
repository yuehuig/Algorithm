package com.yuehuig.union;

public class UnionFind_QU_PH extends UnionFind_QU {

	public UnionFind_QU_PH(int capacity) {
		super(capacity);
	}

	public int find(int v) {
		rangeCheck(v);
		if (v != parents[v]) {
			parents[v] = parents[parents[v]];
			v = parents[v];
		}
		return v;
	}
}
