package strings;
import java.util.*;

public class nMatchedParantheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> result = new ArrayList<String>();
		int n=3;
		generateParantheses(n,0,0,result,"");
		System.out.print(result);
	}
	
	
	// main idea is one count variable for open parantheses and one count variable for close parantheses
	// if count reaches max combination ,store it.
	
	
	
	static void generateParantheses(int n, int open,int close,List<String> result,String cur){
		if(2*n==open+close) {
			result.add(cur);
			return;
		}
		
		if(open<n) {
			generateParantheses(n,open+1,close,result,cur+"(");
		}
		
		if(close<open) {
			generateParantheses(n,open,close+1,result,cur+")");
		}
	}

}
