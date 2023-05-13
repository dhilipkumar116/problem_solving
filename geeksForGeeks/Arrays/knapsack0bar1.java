package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class knapsack0bar1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
//		int w = 50;
//		int[] weights = {10,20,30};
//		int[] values = {60,100,120};
		
 		int w = 7;
 		int[] weights = {1,3,4,5};
 		int[] values = {1,4,5,7};

		System.out.println(recursion(weights,values,w,weights.length-1));
		int[] dp1[] = new int[values.length+1][w+1];
		for(int[] dp:dp1) {Arrays.fill(dp,-1);}
		System.out.println(recursion_memo(weights,values,w,weights.length-1,dp1));
		System.out.println(dp_method(weights,values,w));
	}
	
	public static int recursion(int[] wts,int[] vals,int w,int n) {
		
		if(w==0||n==0) {
			return 0;
		}
		if(w-wts[n]<0) {
			return recursion(wts,vals,w,n-1);
		}else {
			return Math.max(recursion(wts, vals,w-wts[n],n-1)+vals[n]
					,recursion(wts, vals,w,n-1));
		}
		
	}
	
	public static int recursion_memo(int[] wts,int[] vals,int w,int n,int[][] dp) {
		
		
		if(w==0||n==0) {
			return 0;
		}
		
		if(dp[n][w]!=-1) {
			return dp[n][w];
		}
		int ans=0;
		if(w-wts[n]<0) {
			ans = recursion_memo(wts,vals,w,n-1,dp);
		}else {
			ans = Math.max(vals[n]+recursion_memo(wts,vals,w-wts[n],n-1,dp),
					recursion_memo(wts,vals,w,n-1,dp));
		}
		return dp[n][w] = ans; 
	}
	
	public static int dp_method(int[] wts,int[] vals,int w) {
		
		int[][] dp = new int[wts.length+1][w+1];
		
		for(int i=0;i<=wts.length;i++) {
			for(int j=0;j<=w;j++) {

				if(j==0) {continue;}
				if(i==0) {continue;}
				if(wts[i-1]<=j){
					int val=vals[i-1];
					dp[i][j] = Math.max(dp[i-1][j-wts[i-1]]+val,dp[i-1][j]);
				}else {
					dp[i][j] =  dp[i-1][j];
				}
				
				//System.out.print(dp[i][j]+" ");
				
			}
			//System.out.println();
		}
		return dp[wts.length][w];
		
	}

}
