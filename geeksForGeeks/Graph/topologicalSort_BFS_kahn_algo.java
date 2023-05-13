package Graph;

import java.util.*;

public class topologicalSort_BFS_kahn_algo {
	
	static List<List<Integer>> graph;
	int size;
	topologicalSort_BFS_kahn_algo(int node){
		graph = new ArrayList<>();
		size = node;
		for(int i=0;i<=node;i++) {
			graph.add(new ArrayList<>());
		}
	}
	
	private void addEdge(int s,int d) {
		graph.get(s).add(d);
	}
	
	private void kahnAlgo() {
		
		// finding in-degree
		int[] indegree = new int[size+1];
		for(int i=0;i<=size;i++) {
			for(int destinode:graph.get(i)) {
				indegree[destinode]++; 
			}
		}
				
		//algorithm
		Queue<Integer> que = new LinkedList<>();
		//adding vertex with zero indegree
		for(int i=0;i<=size;i++) {
			if(indegree[i]==0) {
				que.add(i);
			}
		}
		while(!que.isEmpty()) {
			int cur = que.poll();
			System.out.print(cur+" ");
			for(int neighbour:graph.get(cur)) {
				indegree[neighbour]--;
				if(indegree[neighbour]==0) {
					que.add(neighbour);
				}
			}
			
		}
		
		
		
	}

	public static void main(String[] args) {
		
		topologicalSort_BFS_kahn_algo g = new topologicalSort_BFS_kahn_algo(5);
		g.addEdge(5, 2); 
        g.addEdge(5, 0); 
        g.addEdge(4, 0); 
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
		g.addEdge(3, 1); 

		g.kahnAlgo();

	}

}
