package all;

import java.util.Arrays;


class DSU {
    int[] parent;
    int[] rank;
    DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.fill(rank, 1);
    }

    public int find(int node) {
        if(parent[node] == node) {
            return parent[node];
        }
        return parent[node] = find(parent[node]);
    }

    public void union(int i, int j) {
        if(rank[i] < rank[j]) {
            parent[i] = parent[j];
            rank[j] +=rank[i];
        }else{
            parent[j] = parent[i];
            rank[i] +=rank[j];
        }
    }

}
public class _261_graph_valid_tree {

	public static void main(String[] args) {
		_261_graph_valid_tree gvt = new _261_graph_valid_tree();
		int n = 3;
		int[][] edges = {{2,0},{2,1}};
		boolean ans = gvt.validTree(n, edges);
		System.out.println(ans);
	}
	


    public boolean validTree(int n, int[][] edges) {
        // TC : o(E) + o(N)
        DSU dsu = new DSU(n);
        Arrays.sort(edges, (a,b) -> a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        for(int[] edge : edges) {
            int parent1 = dsu.find(edge[0]);
            int parent2 = dsu.find(edge[1]);
            if(parent1 == parent2) {
                return false;
            }
            dsu.union(parent1, parent2);
        }
        return edges.length == n-1;
    }

}
