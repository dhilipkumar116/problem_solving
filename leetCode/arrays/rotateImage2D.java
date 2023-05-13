package arrays;

public class rotateImage2D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] matrix = {{1,2,3,},{4,5,6,},{7,8,9}};
		
		System.out.println("before rotating....");
        for(int[] r:matrix) {
        	for(int c:r) {
        		System.out.print(c+"\t");
        	}
        	System.out.println();
        }

        
        // * swap elements in the above diagonal (to get transpose of matrix)
        // * interchange 1st column with last column and so.. 
		  
        int l=matrix.length;   
        for(int i=0;i<l;i++){
            for(int j=i;j<l;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        for(int i=0;i<l;i++){
            for(int j=0;j<l/2;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][l-1-j];
                matrix[i][l-1-j]=temp;
            }
        }
        
    	System.out.println("after rotating....");
        for(int[] r:matrix) {
        	for(int c:r) {
        		System.out.print(c+"\t");
        	}
        	System.out.println();
        }

	}

}
