package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class topologicalSort {
	private ArrayList<Integer>[] graph;
	private int vertex;
	topologicalSort(int size){
		graph = new ArrayList[size];
		for(int i=0;i<size;i++) {
			graph[i] = new ArrayList<>();
		}
		vertex = size;
	}
	
	public void addEdge(int source, int destination) {
		graph[source].add(destination);
	}
	public void printGraph() {
		for(int i=0;i<vertex;i++) {
			System.out.print("vertex "+ i +" is connected to : ");
			for(int val:graph[i]) {
				System.out.print(val+" ");
			}
			System.out.println();
		}
	}
	
	public void topoSort() {
		boolean[] visited = new boolean[vertex];
		Stack<Integer> result = new Stack<>();
		for(int i=0;i<vertex;i++) {
			if(!visited[i]) {
				dfs(visited,result,i);
			}
		}
		while(!result.isEmpty()) {
			System.out.print(result.pop()+" ");
		}
	}
	public void dfs(boolean[] visited,
		Stack<Integer> result, int cur) {
		
		visited[cur]=true;
		for(int val:graph[cur]) {
			if(!visited[val]) {
				dfs(visited,result,val);
			}
		}
		result.push(cur);
	}
	
	public static void main(String[] args) {

		
		/*
		 * topological sorting can be done in only Directed Acyclic Graph(DAG)
		 * it is a linear ordering of vertex such that every directed vertex u,v
		 * (vertex u should come before v in the ordering).
		 * 1 or more sorting results
		 * 
		 * 
		 * 1st part - inDegree 0 elements
		 * middle part - has some inDegree 
		 * last part - outDegree 0 elements
		 * 
		 * */
		topologicalSort g  =  new topologicalSort(6);
	    g.addEdge(5, 2); 
        g.addEdge(5, 0); 
        g.addEdge(4, 0); 
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
		g.addEdge(3, 1); 

		g.printGraph();
		System.out.println("topological sorting....");
		g.topoSort();




		
		
	}

}
