package Graph;


import java.util.*;


public class BipartiteGraph_BFS {
	
	/*
	 * Bipartite Graph - If the vertex-set of a graph G can be split 
	 * into two disjoint sets, V1 and V2 , in such a way that each edge 
	 * in the graph joins a vertex in V1 to a vertex in V2 , and there 
	 * are no edges in G that connect two vertices in V1 or two vertices in V2 , 
	 * then the graph G is called a bipartite graph.
	 * 
	 * 
	 * ->in simple understanding total colors is two and no two vertex should have same color 
	 * ->if odd cycle exists, then it is not bipartite graph
	 * ->if even cycle exists, then it is bipartite graph  
	 * 
	 * */

	static List<List<Integer>> graph;
	BipartiteGraph_BFS(int vertex){
		graph = new ArrayList<>();
		for(int i=0;i<vertex;i++) {
			graph.add(new ArrayList<>());
		}
	}
	
	private boolean BipartiteUtils(int node,int[] color) {
		
		Queue<Integer> que = new LinkedList<>();
		que.add(node);
		color[node]=1;
		while(!que.isEmpty()) {
			Integer current = que.poll();
			for(int neighbour: graph.get(current)) {
				if(color[neighbour]==-1) {
					color[neighbour] = 1 - color[node];
					que.add(neighbour);
				}else if(color[neighbour]==color[node]) {
					return false;
				}
			}
			
		}
		
		return true;
		
	}
	
	private boolean checkBipartite(int n) {
		
		int[] color = new int[n];
		Arrays.fill(color,-1);
		// 1 - green , 0 - blue
		
		for(int i=0;i<n;i++) {
			if(color[i]==-1) {
				if(!BipartiteUtils(i,color)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		int n = 7;
		BipartiteGraph_BFS bi = new BipartiteGraph_BFS(n);
		
		graph.get(0).add(1);graph.get(1).add(0);
		
		graph.get(1).add(2);graph.get(2).add(1);
		
		graph.get(2).add(3);graph.get(3).add(2);
		
		graph.get(4).add(3);graph.get(3).add(4);
		
		graph.get(4).add(5);graph.get(5).add(4);
		
		graph.get(4).add(6);graph.get(6).add(4);
		
		graph.get(1).add(6);graph.get(6).add(1);
		
		if(bi.checkBipartite(n)) {
			System.out.print("bipartite graph");
		}else {
			System.out.print("not a bipartite graph");
		}
		

	}

}
