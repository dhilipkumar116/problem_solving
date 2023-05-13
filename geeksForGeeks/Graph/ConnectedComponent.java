package Graph;

import java.util.*;

public class ConnectedComponent {
	
	static List<Integer>[] graph;
	static int count=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ConnectedComponent cc = new ConnectedComponent();
		int nodes=10;
		int[] from = {1,1,2,3,7};
		int[] to = {2,3,4,5,8};
		graph = new ArrayList[nodes+1];
		for(int i=0;i<nodes+1;i++) {
			graph[i] = new ArrayList<>();
		}
		cc.constructGraph(from,to);
		
		boolean[] visited = new boolean[nodes+1];
		for(int i=1;i<nodes+1;i++) {
			count=0;
			if(!visited[i]) {
				cc.dfs(i,-1,visited);
				System.out.println(i+"-"+(count+1));
			}
		}
		
		
		//cc.printGraph();

	}
	private void dfs(int node,int parent,boolean[] visited) {
		if(visited[node]) {
			return;
		}
		if(graph[node].size()>0) {
			visited[node] = true;
		}
		for(int child:graph[node]) {
			if(parent!=child&&!visited[child]) {
				count++;
				dfs(child,node,visited);
			}
		}
	}
	private void constructGraph(int[] from,int[] to) {
		for(int i=0;i<from.length;i++) {
			graph[from[i]].add(to[i]);
			graph[to[i]].add(from[i]);
		}
	}
	private void printGraph() {
		for(int i=0;i<graph.length;i++) {
			System.out.println(i+" -> "+graph[i]);
		}
	}
}
