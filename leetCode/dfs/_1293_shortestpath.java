package dfs;

public class _1293_shortestpath {

	int[][] grid;
    int ans = Integer.MAX_VALUE;
    int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		_1293_shortestpath obj = new _1293_shortestpath();
		int[][] grid = {{0,1,1},{1,1,1},{1,0,0}};		
		obj.grid = grid;
        int r =  grid.length;
        int c = grid[0].length;
        int k = 1;
        boolean[][] visited = new boolean[r][c];
        obj.helper(0,0,visited,0,k);
        
        System.out.println(obj.ans);
	}
	

	    public void helper(int r, int c,boolean[][] visited,int step, int k) {
	        
	
	        if( r == grid.length-1 && c == grid[0].length-1) {
	            ans = Math.min(ans,step);
	            return;
	        }
	        if( k == 0 ) {
	            return;
	        }
	        visited[r][c] = true;
	        for(int[] dir : dirs) {
	            int nr = dir[0]+r;
	            int nc = dir[1]+c;
	            
	            if(nr >= 0 && nr < grid.length && nc >= 0 &&
	               nc < grid[0].length && !visited[nr][nc]){
	                
	                if(grid[nr][nc] == 1 && k > 0) {
	                    helper(nr, nc, visited, step+1, k-1);
	                }else if(grid[nr][nc] == 0){
	                    helper(nr, nc, visited, step+1, k);
	                }
	            }
	        }
	        visited[r][c] = false;
	    }

}
