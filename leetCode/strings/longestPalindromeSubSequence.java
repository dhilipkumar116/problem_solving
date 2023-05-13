package strings;

public class longestPalindromeSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		
//		"bbbab" by removing a the longest subsequence length is 4
//		"agvdva" by removing g the longest subseqence length is 5
		
		String s = "bbbab";
		
		 int n = s.length();
	        int[][] dp = new int[n][n];
	        
	        int res = 1;
	        for(int i=0;i<n;i++){
	            dp[i][i] = 1;
	        }
	        
	        for(int i=0;i<n-1;i++){
	            if(s.charAt(i)!=s.charAt(i+1)){
	                dp[i][i+1] = 1;
	            }else{
	                dp[i][i+1] = 2;
	            }
	        }
	        
	        for(int k=3;k<=n;k++){
	            
	            for(int start=0;start<n-k+1;start++){
	                
	                int end = k+start-1;
	                
	                if(s.charAt(start)==s.charAt(end)){
	                    dp[start][end] = 
	                        2+dp[start+1][end-1];
	                }else{
	                    dp[start][end] =
	                        Math.max(dp[start][end-1],dp[start+1][end]);
	                }
	                
	            }
	        }
	        
//	         for(int[] r:dp){
//	             for(int c:r){
//	                 System.out.print(c+" ");
//	             }
//	             System.out.println();
//	         }
	        
//	        return dp[0][n-1];

	}

}
