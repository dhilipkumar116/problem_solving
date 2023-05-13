package Graph;

import java.util.*;

public class udcg_using_bfs {
	
	private List<Integer>[] graph;
	udcg_using_bfs(int vertex){
		graph = new ArrayList[vertex+1];
		for(int i=0;i<=vertex;i++) {
			graph[i] = new ArrayList<>();
		}
	}
	private void addEdge(int source,int destination) {
		graph[source].add(destination);
		graph[destination].add(source);
	}
	
	private void detectCycle(int vertex) {
		
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int vertex=4;
		udcg_using_bfs ud = new udcg_using_bfs(vertex);
		ud.addEdge(1,3);
		ud.addEdge(3,4);
		ud.addEdge(4,1);
		ud.addEdge(1,2);
		ud.detectCycle(vertex);

	}

}
