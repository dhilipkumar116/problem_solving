package strings;
import java.util.*;

public class longestPalindromeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//brute force method
			String s = "babad";
		 	int len = s.length();
	        int max = 0;
	        String result = "";
	        for(int i=0;i<len;i++){
	            for(int j=i;j<len;j++){
	                String subString = "";
	                subString = s.substring(i,j+1);
	                int slen = subString.length();
	               
	                if(isPalindrome(subString,slen)){
	                    if( max<=slen){
	                        max = slen;
	                        result="";
	                        result = subString;
	                        subString="";
	                    }
	                }
	                                    
	            }
	        }
       System.out.println(result); 
       dpMethod(s);
       ExpandAroundCenter(s);
       
    }
	


		//brute force method - o(cube) complexity
			public static boolean isPalindrome(String subString,int slen){
			    boolean res = false;
			       if(subString.length()==1){
			           return true;
			       }
			       for(int m=0;m<slen/2;m++){
			           if(subString.charAt(m)==subString.charAt(slen-1-m)){
			               res = true;
			           }else{
			               return false;
			           }
			       }
			   return res;
		}
			
			
			// o(N square) complexity o(N square) space
			// dp solution , key point is we have to fill the dp table diagonally.
		public static void dpMethod(String s){
			int len = s.length();
			int[][] dp = new int[len][len];
			int maxLength=1;
			int startPos = 0;
			// for string of length = 1.
			// filling diagonal values , every char is palindrome here so default maxVal = 1.
			for(int i=0;i<len;i++) {
				dp[i][i]=1;
			}
			
			// for string of length = 2.
			// if char(i)==char(i+1) palindrome = 2 , so we updating maxVal=2.
			for(int i=0;i<len-1;i++) {
				if(s.charAt(i)==s.charAt(i+1)) {
					maxLength = 2;
					dp[i][i+1]=1;
					startPos = i;
				}else {
					dp[i][i+1]=0;
				}
			}
			//for string of length = 3.
			//we have to fill the table with 3rd index diagonally(k). and so...
			//initially length of substring = 3 , subsequently length will be increased....
			for(int k=3;k<=len;++k) {
				//fix the starting index
				for(int start=0;start<len-k+1;++start) {
					int end = start+k-1;
					//checking the start and end character is same and also
					//checking start+1 , end-1(inner string of current string) using dp table.
					if(s.charAt(start)==s.charAt(end)&&dp[start+1][end-1]==1) {
						dp[start][end]=1;
						if(maxLength<k) {
							maxLength=k;
							startPos = start;
						}
					}else {
						dp[start][end]=0;
					}
				}
			}
			
			System.out.println(s.substring(startPos,startPos+maxLength));
		}
		
		
		
		// expand around the center approach // o(N square) - complexity , 0(1) - space
		static void ExpandAroundCenter(String s){
			int start=0,end=0;
			int len = s.length();
			int maxLen = 0;
			for(int i=0;i<len;i++) {
				int len1 = expandFromMiddle(s,i,i); // for odd string
				int len2 = expandFromMiddle(s,i,i+1); // for even string
				int curLen = Math.max(len1, len2);
				if(curLen>end-start) {
					start= i-((curLen-1)/2);
					end=i+((curLen)/2);
				}
			}
			System.out.print(s.substring(start,end+1));
		}
		
		static int expandFromMiddle(String s,int left,int right) {
			
			if(s==null||left>right) return 0;
			
			while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)) {
				left--;
				right++;
			}
			return right-left-1;
		}
		
		
}
