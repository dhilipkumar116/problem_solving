package Graph;
import java.util.*;

public class AdjacencyList {
	
	private final static int A=0;
	private final static int B=1;
	private final static int C=2;
	private final static int D=3;
	private final static int E=4;
	private final static int F=5;
	private final static int G=6;
	private final static int H=7;
	private final int vertex=8;
	
	
	// for weighted graph
	/*
	 *static class Edge{
	 *	int source;
	 *	int destination;
	 *	int weight;
	 *	Edge(int source, int destination, int weight){
	 *		this.source = source;
	 *		this.destination = destination;
	 *		this.weight = weight;
	 *	}
	 *
	 *}
	 *
	 *	private LinkedList<Edge>[] list;
	 * */
	
	
	private LinkedList<Integer>[] list;
	
	
	AdjacencyList(){
		list = new LinkedList[vertex];
		for(int i=0;i<vertex;i++) {
			list[i] = new LinkedList<>();
		}
	}
	
	
	void addEdge(int source,int destination) {
		list[source].add(destination);
		list[destination].add(source); // for undirected graph
	}
	
	void printGraph() {
		for(int i=0;i<vertex;i++) {
			System.out.print("vertex "+getVertex(i)+" is connected to : ");
			for(int j=0;j<list[i].size();j++) {
				System.out.print(getVertex(list[i].get(j))+" ");
			}
			System.out.println();
		}
	}
	
	char getVertex(int i) {
		
		if(i==0) return 'A';
		if(i==1) return 'B';
		if(i==2) return 'C';
		if(i==3) return 'D';
		if(i==4) return 'E';
		if(i==5) return 'F';
		if(i==6) return 'G';
		if(i==7) return 'H';
		
		return '0';
	}
	

	public static void main(String[] args) {
	
		AdjacencyList graph = new AdjacencyList();
		graph.addEdge(A, B);
		graph.addEdge(A, D);
		graph.addEdge(A, C);
		graph.addEdge(B, E);
		graph.addEdge(B, F);
		graph.addEdge(C, G);
		graph.addEdge(D, H);
		graph.addEdge(E, H);
		graph.addEdge(G, H);
		graph.addEdge(F, H);
		
		graph.printGraph();

	}

}
