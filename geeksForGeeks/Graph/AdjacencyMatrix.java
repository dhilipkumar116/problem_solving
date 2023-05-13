package Graph;

public class AdjacencyMatrix {

	private final static int A=0;
	private final static int B=1;
	private final static int C=2;
	private final static int D=3;
	private final static int E=4;
	private final static int F=5;
	private final static int G=6;
	private final static int H=7;
	private final int vertex=8;
	private boolean[][] adjMatrix;
	
	AdjacencyMatrix() {
		adjMatrix = new boolean[vertex][vertex];
	}
	
	
	void addEdge(int source, int destination) {
		adjMatrix[source][destination] = true;
		adjMatrix[destination][source] = true; // for undirected graph
	}
	void removeEdge(int source, int destination) {
		adjMatrix[source][destination] = false;
		adjMatrix[destination][source] = false; // for undirected graph
	}
	
	void printGraph() {
//		 System.out.println("Graph: (Adjacency Matrix)");
//	        for (int i = 0; i < vertex; i++) {
//	            for (int j = 0; j <vertex ; j++) {
//	                System.out.print(adjMatrix[i][j]+ " ");
//	            }
//	            System.out.println();
//	     }
	        
	    for(int i=0;i<vertex;i++) {
	    	System.out.print("vertex "+getVertex(i)+" is connected to : ");
	    	for(int j=0;j<vertex;j++) {
	    		if(adjMatrix[i][j]==true) {
	    			System.out.print(getVertex(j)+" ");
	    		}
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

		AdjacencyMatrix graph = new AdjacencyMatrix();
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
