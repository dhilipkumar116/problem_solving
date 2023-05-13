package Graph;
import java.util.*;


public class DijkstraAlgoSIngleSourcePQ {
	
	class AdjNode{
		int v;
		int weight;
		AdjNode(int v,int w){
			this.v = v;
			this.weight = w;
		}
	}
	
	List<List<AdjNode>> graph;
 	DijkstraAlgoSIngleSourcePQ(int vertex){
 		graph = new ArrayList<>();
 		for(int i=0;i<=vertex;i++) {
 			graph.add(new ArrayList<>());
 		}
	}
 	
 	public void addEdge(int u,int v,int w) {
 		graph.get(u).add(new AdjNode(v,w));
 		graph.get(v).add(new AdjNode(u,w)); 		
 	}
 	
 	private void dijkstra(int src,int vertex) {
 		
 		int[] distance = new int[vertex+1];
 		Arrays.fill(distance, Integer.MAX_VALUE);
 		distance[src]=0;
 		
 		// pq is used to get always min weights among them (greedy approach)
 		PriorityQueue<AdjNode> pq = new PriorityQueue<>((a,b)->a.weight-b.weight);
 		
 		pq.add(new AdjNode(src,0));
 		
 		while(!pq.isEmpty()) {
 			AdjNode cur = pq.poll();
 			for(AdjNode neighbour:graph.get(cur.v)) {
 				if(distance[cur.v]+neighbour.weight<distance[neighbour.v]) {
 					distance[neighbour.v] = distance[cur.v]+neighbour.weight;
 					pq.add(new AdjNode(neighbour.v,distance[neighbour.v]));
// 					System.out.println(neighbour.v+"-"+distance[neighbour.v]);
 				}
 			}
 		}
 		
 		for(int i=1;i<distance.length;i++) {
 			System.out.println("shortest dist from node-"+src+" to node-"+i+":"+distance[i]);
 		}
 		
 		
 	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int vertex  = 5;
		DijkstraAlgoSIngleSourcePQ g = new DijkstraAlgoSIngleSourcePQ(vertex);
		g.addEdge(1, 2, 2);
		g.addEdge(1, 4, 1);
		g.addEdge(2, 5, 5);
		g.addEdge(2, 3, 4);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		g.addEdge(3, 5, 1);
		g.addEdge(4, 3, 3);
		
		int src=1;
		g.dijkstra(src,vertex);
	}

}
