package Graph;

import java.util.*;

public class shortestDistUndirectedGraph {

	List<List<Integer>> graph;
	shortestDistUndirectedGraph(int vertex){
		graph = new ArrayList<>();
		for(int i=0;i<=vertex;i++) {
			graph.add(new ArrayList<>());
		}
	}
	
	private void addEdge(int s,int d) {
		graph.get(s).add(d);
		graph.get(d).add(s);
	}
	
	private void findDistanceBFS(int vertex,int start,int desti) {
		int[] distance = new int[vertex];
		Arrays.fill(distance,Integer.MAX_VALUE);
		distance[start]=0;
		Queue<Integer> que = new LinkedList<>();
		que.add(start);
		while(!que.isEmpty()) {
			int cur = que.poll();
			for(int neighbour:graph.get(cur)) {
				if(distance[cur]+1<distance[neighbour]) {
					distance[neighbour]=distance[cur]+1;
					que.add(neighbour);
				}
			}	
		}
		
		for(int i=0;i<distance.length;i++) {
			System.out.println(start+"-"+i+" : "+distance[i]);
		}
		
		System.out.print("shortest distance from node "+start+" to node "+desti+":"+distance[desti]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int vertex = 9;
		shortestDistUndirectedGraph g = new shortestDistUndirectedGraph(8);
		g.addEdge(0,1);
		g.addEdge(0,3);
		g.addEdge(1,2);
		g.addEdge(1,3);
		g.addEdge(2,6);
		g.addEdge(3,4);
		g.addEdge(4,5);
		g.addEdge(5,8);
		g.addEdge(6,7);
		g.addEdge(6,8);
		g.addEdge(7,8);
		
		int startVertex=0;
		int destiVertex=6;
		g.findDistanceBFS(vertex,startVertex,destiVertex);
		

	}

}
