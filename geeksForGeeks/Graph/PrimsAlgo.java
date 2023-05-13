package Graph;

import java.util.Arrays;

public class PrimsAlgo {
	//used to find minimum cost spanning tree of a graph
	//refer note
	//time - 0(v*v)
	
	static int vertex = 6;

	
	private static void findMST(int[][] graph) {
		
		int[] parent = new int[vertex];
		int[] value = new int[vertex]; //value used to pick minimum weight edge in cut
		boolean[] setMst = new boolean[vertex];
		Arrays.fill(value,Integer.MAX_VALUE);
		value[0]=0;
		parent[0]=-1;
		
		for(int start=0;start<vertex-1;start++) {
			
			int u = findMinWeight(value,setMst);
			setMst[u]=true;
			for(int v=0;v<vertex;v++) {
				if(graph[u][v]!=0&&setMst[v]==false&&graph[u][v]<value[v]) {
					parent[v]=u;
					value[v]=graph[u][v];
				}
			}
			
		}
		
		printMst(parent,value);
	}
	
	private static int findMinWeight(int[] value,boolean[] setMst) {
		
		int index=-1;
		int min=Integer.MAX_VALUE;
		for(int v=0;v<vertex;v++) {
			if(value[v]<min&&setMst[v]==false) {
				min = value[v];
				index = v;
			}
		}
		return index;
	}
	
	private static void printMst(int[] parent,int[] value) {
		for(int i=1;i<vertex;i++) {
			System.out.println("edge(u->v) "+parent[i]+"->"+i+" : "+value[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] graph = new int[][] {
										{0,4,6,0,0,0},
										{4,0,6,3,4,0},
										{6,6,0,1,0,0},
										{0,3,1,0,2,3},
										{0,4,0,2,0,7},
										{0,0,0,3,7,0}
									};
		findMST(graph);
		

	}

}
