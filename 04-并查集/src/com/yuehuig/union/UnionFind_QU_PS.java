package com.yuehuig.union;

/// 路径分裂
public class UnionFind_QU_PS extends UnionFind_QU {

	public UnionFind_QU_PS(int capacity) {
		super(capacity);
	}
	
	public int find(int v) {
		rangeCheck(v);
		if (v != parents[v]) {
			int parent = parents[v];
			parents[v] = parents[parent];
			v = parent;
		}
		return v;
	}

}
