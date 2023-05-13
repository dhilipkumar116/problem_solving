package Graph;

import java.util.HashSet;
import java.util.LinkedList;

public class dfs {

	private int vertex=6;
	private LinkedList<Integer>[] list;
	
	dfs(int vertex){
		list = new LinkedList[vertex+1];
		for(int i=1;i<=vertex;i++) {
			list[i] = new LinkedList<>();
		}
	}
	
	void addEdge(int source, int destination) {
		list[source].add(destination);
		list[destination].add(source);// for undirected graph
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
	
	
	void traverse1(HashSet<Integer> set,int source) {
		if(set.contains(source)) {
			return;
		}
		set.add(source);
		System.out.print(source+" ");
		for(int i=0;i<list[source].size();i++) {
			if(!set.contains(list[source].get(i))){
				traverse1(set,list[source].get(i));
			}
		}
		
	}
	void dfsAt(int source) {
		HashSet<Integer> set = new HashSet<>();
		traverse1(set,source);
	}
	void traverse2(boolean[] isVisited,int source) {
		if(isVisited[source]) {return;}
		isVisited[source]=true;
		System.out.print(source+" ");
		for(int i=0;i<list[source].size();i++) {
			if(!isVisited[list[source].get(i)]) {
				traverse2(isVisited,list[source].get(i));
			}
		}
	}
	void dfsUsingArray(int source) {
		boolean[] isVisited = new boolean[vertex+1];
		traverse2(isVisited,source);
	}
	
	public static void main(String[] args) {
		
		dfs graph = new dfs(6);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(2, 5);
		graph.addEdge(3, 5);
		graph.addEdge(4, 5);
		graph.addEdge(4, 6);
		graph.addEdge(5, 6);
		//graph.printGraph();
		
		graph.dfsAt(2);
		System.out.println();
		graph.dfsUsingArray(2);

	}

}
