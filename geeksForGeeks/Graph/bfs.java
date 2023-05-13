package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class bfs {
	
	private int vertex;
	private LinkedList<Integer>[] list;
	
	
	bfs(int vertex){
		this.vertex = vertex;
		list = new LinkedList[vertex+1];
		for(int i=1;i<=vertex;i++) {
			list[i] = new LinkedList<>();
		}
	}
	
	void addEdge(int source,int destination) {
		list[source].add(destination);
		list[destination].add(source);// for undirected graph
	}
	
	void bfsAt(int source) {
		HashSet<Integer> set = new HashSet<>();
		Queue<Integer> que = new LinkedList<>();
		que.add(source);
		set.add(source);
		while(!que.isEmpty()) {
			int cur = que.poll();
			System.out.print(cur+" ");
			for(int i=0;i<list[cur].size();i++) {
				if(set.add(list[cur].get(i))){
					que.add(list[cur].get(i));
				}
			}
			
		}
		System.out.println();
	}
	
	void bfsUsingArray(int source) {
		
		Queue<Integer> que = new LinkedList<>();
		que.add(source);
		boolean[] isVisited = new boolean[vertex+1];
		isVisited[source] = true;
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			System.out.print(cur+" ");
			for(int i=0;i<list[cur].size();i++) {
				// 0 index is dummy in isVisited array
				if(isVisited[list[cur].get(i)]==false) {
					isVisited[list[cur].get(i)]=true;
					que.add(list[cur].get(i));
				}
			}
		}
		
	}
	
	
	void printGraph() {
		for(int i=1;i<=vertex;i++) {
			System.out.print("vertex "+i+" is connected to : ");
			for(int j=0;j<list[i].size();j++) {
				System.out.print(list[i].get(j)+" ");
			}
			System.out.println();
		}
	}
	

	public static void main(String[] args) {
		
		bfs graph = new bfs(6);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(2, 5);
		graph.addEdge(3, 5);
		graph.addEdge(4, 5);
		graph.addEdge(4, 6);
		graph.addEdge(5, 6);
		//graph.printGraph();
		
		graph.bfsAt(1);
		graph.bfsUsingArray(2);

		
	}

}
