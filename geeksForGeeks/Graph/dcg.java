package Graph;

import java.util.LinkedList;

//directed cyclic graph
public class dcg {
	
	int vertex;
	public LinkedList<LinkedList<Integer>> graph;
	dcg(int vertex){
		this.vertex=vertex;
		graph = new LinkedList<>();
		for(int i=0;i<vertex;i++) {
			graph.add(new LinkedList<>());
		}
	}
	
	public void addEdge(int source, int destination) {
		graph.get(source).add(destination);
	}

	
	private boolean isCycleFound() {
		//put the currently visiting vertex to the gray set 
		//if currently visiting vertex is present in gray set , then is cycle
		
		
		//0-white
		//1-gray
		//2-black
		int[] visited = new int[vertex];
		for(int i=0;i<vertex;i++) {
			if(visited[i]==0) {
				if(isFound(visited,i)) {
					return true;
				}
			}
		}
		
		
		return false;
	}
	
	private boolean isFound(int[] visited,int source) {
		
		visited[source]=1;
		for(int i=0;i<graph.get(source).size();i++) {
			int adjVertex = graph.get(source).get(i);
			if(visited[adjVertex]==1) {
				return true;
			}
			if(isFound(visited,adjVertex)){
				return true;
			}
		}
		visited[source]=2;
		return false;
	}

	
	public static void main(String[] args) {

		
		//white set - has not visited vertex
		//gray set - has being visited vertex right now
		//black  set - has visited(all adjacent vertex has been visited)
		dcg g= new dcg(5);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(0,3);
		g.addEdge(1,2);
		g.addEdge(3,4);
		g.addEdge(4,0);
		System.out.println(g.isCycleFound());
	}

}
