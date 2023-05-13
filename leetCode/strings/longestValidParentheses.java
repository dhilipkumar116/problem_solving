package strings;
import java.util.*;

public class longestValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "(()()(";
		System.out.println(longestValidParentheses(s));

	}

	// main idea is store flag of the continuous pair of parentheses
	// and count the max continuous pair
	 static int longestValidParentheses(String s) {
	        
		 
		 // to store the index of open parentheses
	        Stack<Integer> stack = new Stack<Integer>();
	        // to store the flag value for the pair of parentheses
	        int[] dp = new int[s.length()];
	        int max = 0;
	        int count=0;
	        for(int i=0;i<s.length();i++){
	            char curChar = s.charAt(i);
	            if(curChar=='('){
	                stack.push(i);
	            }else if(!stack.isEmpty()){
	            
	            	//if char is closed parentheses get the prev index and store the flag in cur and prev index
	                int prev = stack.peek();
	                dp[prev]=1;
	                dp[i]=1;
	                stack.pop();
	            
	            }

	        }
	        
	        // to count continuous pair of parentheses
	        for(int i=0;i<dp.length;i++){
	            if(dp[i]==0){
	                count=0;
	            }else{
	                count +=1;
	            }
	            max = Math.max(max,count);
	        }
	        return max;
	        
	    }
}
