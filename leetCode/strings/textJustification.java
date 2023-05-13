package strings;
import java.util.*;

public class textJustification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] words = {"this","is","an","example","of","the","text","justification."};
		int width=16;
		System.out.println(fullJustify(words,width));

	}
	
	/*
	 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
		Output:
		[
		  "What   must   be",
		  "acknowledgment  ",
		  "shall be        "
		]
		Explanation: Note that the last line is "shall be 
		   " instead of "shall     be", because the last 
		   line must be left-justified instead of fully-justified.
		Note that the second line is also left-justified because it contains only one word.
	 * */

	//main idea is finding left and right word by calculating curLen<maxWidth
	//and adding words to the single string
	
	 public static List<String> fullJustify(String[] words, int maxWidth) {
	        
	        List<String> list = new ArrayList<>();
	        int left=0;
	        int curLen = 0;
	        while(left<words.length){
	            int right=left+1;
	            curLen=words[left].length();
	            while(right<words.length){
	                if(curLen+words[right].length()+1>maxWidth){
	                    break;
	                }
	                curLen +=words[right].length()+1;//1 is for the one space between the words
	                right++;
	            }
	            String s = getSingleLine(left,right,
	                                     maxWidth,words.length,words,curLen);
	            list.add(s.toString());
	            left=right;
	        }
	        return list;
	    }
	    
	    static String getSingleLine(int left,int right,
	                         int maxWidth,int n,String[] words,int curLen){
	        StringBuilder sb = new StringBuilder();
	        int gaps = right-left-1;
	        // for last line
	        if(gaps==0||right==n){
	            
	            for(int i=left;i<right;i++){
	                sb.append(words[i]);
	                sb.append(' ');
	                sb.deleteCharAt(sb.length()-1);//delete the last one in line
	                while(sb.length()<maxWidth){
	                    sb.append(' ');
	                }
	            }
	            
	        }else{
	            // not for last line
	            int freeSpace = (maxWidth-curLen)/gaps;
	            int rest = (maxWidth-curLen)%gaps; 
	            // in some case freeSpace=0 , to add padding as left as possible based on rest value
	            //eg freeSpace = 1/2 = 0, rest = 1%2 = 1,if rest is greater than i-left add 1 with freeSpace
	            										
	   
	            for(int i=left;i<right-1;i++){
	                sb.append(words[i]);
	                sb.append(' ');
	                for(int q=0;q<freeSpace+(i-left<rest?1:0);q++){
	                    sb.append(' ');
	                }
	            }
	            sb.append(words[right-1]);
	        }
	        
	        return sb.toString();
	    }
}
