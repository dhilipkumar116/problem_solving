package Graph;
import java.util.*;

public class shortestDistWeightedDAG {
	
	class AdjNode{
		int v;
		int weight;
		AdjNode(int v,int w){
			this.v = v;
			this.weight = w;
		}
	}
	
	List<List<AdjNode>> graph;
	shortestDistWeightedDAG(int vertex){
		graph = new ArrayList<>();
		for(int i=0;i<=vertex;i++) {
			graph.add(new ArrayList<>());
		}
	}
	
	private void addEdge(int u,int v,int w) {
		graph.get(u).add(new AdjNode(v,w));
	}
	
	private void topoSort(int i,int[] visited,Stack<Integer> stack) {
		visited[i] = 1;
		for(AdjNode neighbour:graph.get(i)) {
			if(visited[neighbour.v]==0) {
				topoSort(neighbour.v,visited,stack);
			}
		}
		stack.push(i);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int vertex=6;
		shortestDistWeightedDAG g = new shortestDistWeightedDAG(vertex);
		g.addEdge(0,1,2);
		g.addEdge(0,4,1);
		g.addEdge(1,2,3);
		g.addEdge(4,2,2);
		g.addEdge(4,5,4);
		g.addEdge(2,3,6);
		g.addEdge(5,3,1);
		
		// topo sort
		Stack<Integer> stack = new Stack();
		int[] visited = new int[vertex+1];
		for(int i=0;i<vertex;i++) {
			if(visited[i]==0) {
				g.topoSort(i,visited,stack);
			}
		}


		// finding shortest distance
		int start = 0;
		int[] distance = new int[vertex];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start]=0;
		while(!stack.isEmpty()) {
			int current = stack.pop();
			for(AdjNode neighbour:g.graph.get(current)) {
				if(neighbour.weight+distance[current]<distance[neighbour.v]) {
					distance[neighbour.v] = neighbour.weight+distance[current];
				}
			}
		}
		
		for(int i=0;i<vertex;i++) {
			System.out.println("shortest dist from node "+start+" to node "+i+":"+distance[i]);
		}
	}

}
