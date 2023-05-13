package Graph;

import java.util.HashSet;
import java.util.LinkedList;

//undirected cyclic graph
public class udcg_using_dfs {

	int vertex;
	public LinkedList<LinkedList<Integer>> graph;
	udcg_using_dfs(int vertex){
		this.vertex=vertex;
		graph = new LinkedList<>();
		for(int i=0;i<vertex;i++) {
			graph.add(new LinkedList<>());
		}
	}
	
	public void addEdge(int source, int destination) {
		graph.get(source).add(destination);
		graph.get(destination).add(source);
	}
	
	public boolean isFound(HashSet<Integer> visited,int source,int parent) {
		
		visited.add(source);
		for(int i=0;i<graph.get(source).size();i++) {
			int adjVertex=graph.get(source).get(i);
			if(parent==adjVertex) {continue;}
			// if it contains , then i came from some other source,then its cycle
			if(visited.contains(adjVertex)) {
				return true;
			}
			if(isFound(visited,adjVertex,source)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isCycleFound() {
		HashSet<Integer> visited = new HashSet<>();
		for(int i=0;i<vertex;i++) {
			if(visited.contains(i)) {continue;}
			if(isFound(visited,i,-1)){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {

		udcg_using_dfs g= new udcg_using_dfs(4);
		g.addEdge(0,2);
		g.addEdge(2,3);
		g.addEdge(3,0);
		g.addEdge(0,1);
		
		System.out.println(g.isCycleFound());
	}

}
