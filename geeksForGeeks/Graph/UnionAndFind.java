package Graph;
import java.util.*;

public class UnionAndFind {

//	disjoint set - union & find is used to find cycle in undirected graph
//  there is a universal set
//  we have to construct separate set using source and destination node with set name as parent index
//	if source and destination as same parent(ie: same set) means cycle is present in graph
	
	public static void main(String[] args) {
		
		
		int[][] graph = {{1,2},{2,3},{3,4},{1,4},{1,5}};
		int n = 5;
		DSU dsu = new DSU(n);

	}

}

class DSU{
	int[] parent;
	int[] rank;
	DSU(int n) {
		parent = new int[n];
		rank = new int[n];
		for(int i=0; i<n; i++) {
			parent[i] = i;
		}
		Arrays.fill(rank, 1);
	}
	
//	path compression/collapse find technique
	public int find(int i) {
		if(parent[i]==i) {
			return i;
		}
		return parent[i] = find(parent[i]);
	}
	
	public void union(int a,int b) {
		if(rank[a] > rank[b]) {
			parent[b] = parent[a];
			rank[a] +=rank[b];
		}else {
			parent[a] = parent[b];
			rank[b] +=rank[a];
		}
	}
	
}