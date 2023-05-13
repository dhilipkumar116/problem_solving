package graph;
import java.util.LinkedList;
import java.util.Queue;

public class _01_flood_fill_733 {

	public static void main(String[] args) {

		int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
		int color = 3;
		int sr = 1;
		int sc = 1;
		
		int row =  image.length;
        int col =  image[0].length;

        int oldColor = image[sr][sc];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{sr,sc});
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
        while( !que.isEmpty() ) {
            int[] dir = que.poll();        
            image[dir[0]][dir[1]] = color;
            for(int[] d : dirs) {
                int nr = d[0]+dir[0];
                int nc = d[1]+dir[1];
                if(nr >= 0 && nr < image.length && nc >=0 &&
                    nc < image[0].length &&
                     image[nr][nc] == oldColor) {
                         que.add(new int[]{nr,nc});
                     }
            }
        }
        
        
        for(int[] pixels : image) {
        	for(int p : pixels) {
        		System.out.print(p+" ");
        	}
        	System.out.println();
        }
        
	}

}
