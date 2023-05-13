package Graph;

import java.util.Arrays;

public class DijkstraAlgoSingleSource {
	
	private static int findMinDist(int[] distance,boolean[] visited) {
		
		int min = Integer.MAX_VALUE;
		int index = -1;
		for(int i=0;i<distance.length;i++) {
			if(distance[i]<min&&!visited[i]) {
				min = distance[i];
				index=i;
			}
		}
		return index;
		
	}
	
	private static void findShortestPath(int[][] graph,int source) {
		
		int V = graph[0].length;
		
		boolean[] visited = new boolean[V];
		int[] distance = new int[V];
		
		Arrays.fill(distance,Integer.MAX_VALUE);
		distance[source] = 0;
		
		for(int i=0;i<V-1;i++) {
			
			int u = findMinDist(distance,visited);
			visited[u]=true;
			
			for(int v=0;v<V;v++) {
				
				if(!visited[v]&&
						graph[u][v]!=0&&
						distance[u]!=Integer.MAX_VALUE&&
						distance[u]+graph[u][v]<distance[v]){
					distance[v] = distance[u]+graph[u][v];
				}
				
			}
			
		}
		
		
		//printing weights
		System.out.println("vertex   distance from source");
		for(int i=0;i<V;i++) {
			System.out.println(i+"     "+distance[i]);
		}
		
		
	}
	

	public static void main(String[] args) {

		int[][] graph = new int[][] {
										{0,1,4,0,0,0},
										{1,0,4,2,7,0},
										{4,4,0,3,5,0},
										{0,2,3,0,4,6},
										{0,7,5,4,0,7},
										{0,0,0,6,7,0}
									};
	
		int source = 0;							
		findShortestPath(graph,source);
		
		
		
	}

}
