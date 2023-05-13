package Graph;

import java.util.*;

class Graph{
	
	//https://leetcode.com/problems/min-cost-to-connect-all-points/solution/
	
	class Edge implements Comparable<Edge>{
		int scr,desti,weight;
		public int compareTo(Edge compareEdge) {
			return this.weight-compareEdge.weight;
		}
	}
	
	int vertices,edges;
	Edge[] edge;
	Graph(int v, int e) {

		this.vertices=v;
		this.edges=e;
		edge = new Edge[edges];
		for(int i=0;i<e;i++) {
			edge[i] = new Edge();
		}
	}
	
	//union
	class subset{
		int parent;
		int rank;
	}
	// find and union by rank compression technique
	protected int find(subset[] subsets,int i) {
		if (subsets[i].parent != i)
		      subsets[i].parent = find(subsets, subsets[i].parent);
		return subsets[i].parent;
	}

	protected void union(subset[] subsets,int x,int y) {
		int xParent = find(subsets,x);
		int yParent = find(subsets,y);
		
		if(subsets[xParent].rank<subsets[yParent].rank) {
			subsets[xParent].parent = yParent;
		}else if(subsets[xParent].rank>subsets[yParent].rank){
			subsets[yParent].parent = xParent;
		}else {
			subsets[yParent].parent = xParent;
			subsets[xParent].rank++;
		}
	}
	
	protected void findMST(){
		
		Edge[] result = new Edge[vertices];
		int i=0;
		for(i=0;i<vertices;i++) {
			result[i] = new Edge();
		}
		
		Arrays.sort(edge);
		subset[] subsets = new subset[vertices];
		for(i=0;i<vertices;i++) {
			subsets[i] = new subset();
		}
		
		for(int v=0;v<vertices;v++) {
			subsets[v].parent = v;
			subsets[v].rank=0;
		}
		
		int e=0;
		i=0;
		while(e<vertices-1) {
			Edge next_edge = edge[i++];
			int srcParent = find(subsets,next_edge.scr);
			int destParent = find(subsets,next_edge.desti);
			
			
			if(srcParent!=destParent) {
				result[e++] = next_edge;
				union(subsets,srcParent,destParent);
			}
		}
	
		System.out.println("printing MST");
		System.out.println("src-desti:weight");
		for(i=0;i<e;i++) {
			System.out.println(result[i].scr+" - "+result[i].desti+" : "+result[i].weight);
		}
		
	}
	
}



public class KruskalsAlgo {
		
	public static void main(String[] args) {
		
		int vertex=6;
		int edge=10;
		Graph G = new Graph(vertex,edge);
		G.edge[0].scr=0;
		G.edge[0].desti=1;
		G.edge[0].weight=1;

		G.edge[1].scr=0;
		G.edge[1].desti=2;
		G.edge[1].weight=2;
		
		G.edge[2].scr=1;
		G.edge[2].desti=2;
		G.edge[2].weight=3;
		
		G.edge[3].scr=1;
		G.edge[3].desti=4;
		G.edge[3].weight=3;
		
		G.edge[4].scr=1;
		G.edge[4].desti=3;
		G.edge[4].weight=1;
		
		G.edge[5].scr=2;
		G.edge[5].desti=4;
		G.edge[5].weight=1;
		
		G.edge[6].scr=2;
		G.edge[6].desti=3;
		G.edge[6].weight=2;
		
		G.edge[7].scr=4;
		G.edge[7].desti=3;
		G.edge[7].weight=2;
		
		G.edge[8].scr=4;
		G.edge[8].desti=5;
		G.edge[8].weight=3;
		
		G.edge[9].scr=3;
		G.edge[9].desti=5;
		G.edge[9].weight=4;
		G.findMST();
	}

}
