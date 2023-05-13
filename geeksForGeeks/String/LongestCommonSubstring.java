package String;
import java.util.*;

public class LongestCommonSubstring {

	
	static Integer[][] dp; 
	public static void main(String[] args) {

		LongestCommonSubstring lcs = new LongestCommonSubstring();
		String s1 = "ABCDGH";
		String s2 = "ACDGHR";
		
		dp = new Integer[s1.length()][s2.length()];
		
//		System.out.println(lcs.helper(s1,s2,0,0,0));
		
//		System.out.println(lcs.helperRecDP(s1,s2,0,0,0));
		
//		System.out.println(lcs.helperDP(s1,s2));
		
		System.out.print(lcs.helperSpaceDP(s1,s2));
	}
	
	public int helper(String s1,String s2,int i,int j,int len) {
//		TC : 2^Math.max(n,m) * 2
//		SC : Math.max(n,m)
		if(s1.length() == i || s2.length() == j) {
			return len;
		}
		if(s1.charAt(i) == s2.charAt(j)) {
			len = helper(s1,s2,i+1,j+1,len+1);
		}
		
		return Math.max(len, Math.max(helper(s1,s2,i,j+1,0),helper(s1,s2,i+1,j,0)));
		
	}
	
	public int helperRecDP(String s1,String s2,int i,int j,int len) {
//		TC : n*m
//		SC : n*m
		
		if(dp[i][j]!=null) {
			return dp[i][j];
		}
		if(s1.length() == i || s2.length() == j) {
			return len;
		}
		if(s1.charAt(i) == s2.charAt(j)) {
			len = helper(s1,s2,i+1,j+1,len+1);
		}
		
		return dp[i][j] = Math.max(len, Math.max(helper(s1,s2,i,j+1,0),helper(s1,s2,i+1,j,0)));
		
	}
	
	public int helperDP(String s1,String s2) {
		
		int n = s1.length();
		int m = s2.length();
		
		int[][] dp = new int[n+1][m+1];
		
		int result = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = 1+dp[i-1][j-1];
					result = Math.max(result, dp[i][j]);
				}
			}
		}
		return result;
	}
	
	public int helperSpaceDP(String s1,String s2) {
		
		int n = s1.length();
		int m = s2.length();
		int[][] dp = new int[2][m+1];
		int result=0;
		
		
		int endIdx=0;
		int i;
		for(i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i%2][j] = 1 + dp[(i-1)%2][j-1];
//					result = Math.max(result, dp[i%2][j]);
					
//					to print substring
					if(result<dp[i%2][j]) {
						result = dp[i%2][j];
						endIdx = j-1;
					}
				}else {
					dp[i%2][j] = 0;
				}
			}
		}
		
		
		int startIdx = endIdx-result+1;
		System.out.println("substring : "+s2.substring(startIdx,startIdx+result));
		return result;
		
		
		
	}

}
