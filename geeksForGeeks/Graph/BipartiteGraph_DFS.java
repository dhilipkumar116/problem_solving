package Graph;

import java.util.*;

public class BipartiteGraph_DFS {
	
	static List<List<Integer>> graph;
	BipartiteGraph_DFS(int vertex){
		graph = new ArrayList<>();
		
		for(int i=0;i<vertex;i++) {
			graph.add(new ArrayList<>());
		}
	}
	
	private boolean bipartiteUtils(int node,int[] color) {
		
		if(color[node]==-1) {
			color[node] = 1;
		}
		for(int neighbour:graph.get(node)) {
			
			if(color[neighbour]==-1) {
				color[neighbour] = 1-color[node];
				if(!bipartiteUtils(neighbour,color)) {
					return false;
				}
			}else if(color[node]==color[neighbour]) {
				return false;
			}
		}
		return true;
		
	}
	
	private boolean checkBipartite(int n) {
		
		int[] color = new int[n];
		Arrays.fill(color, -1);
		
		for(int i=0;i<n;i++) {
			if(color[i]==-1) {
				if(!bipartiteUtils(i,color)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=7;
		BipartiteGraph_DFS bi = new BipartiteGraph_DFS(n);
		
		graph.get(0).add(1);graph.get(1).add(0);
		
		graph.get(1).add(2);graph.get(2).add(1);
		
		graph.get(2).add(3);graph.get(3).add(2);
		
		graph.get(4).add(3);graph.get(3).add(4);
		
		graph.get(4).add(5);graph.get(5).add(4);
		
		graph.get(4).add(6);graph.get(6).add(4);
		
		graph.get(1).add(6);graph.get(6).add(1);
		
		if(bi.checkBipartite(n)) {
			System.out.println("bipartite graph");
		}else {
			System.out.println("not a bipartite graph");
		}
		

	}

}
