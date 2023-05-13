package strings;
import java.util.*;

public class longestSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// optimised sol
			String s = "abcabcbb";
	   	    int start=0,current=0,max=0;
	   	    Set<Character> set = new HashSet<>();
	   	    while(current<s.length()) {
	   	    	if(set.contains(s.charAt(current))) {
	   	    		//if it contains in list increment the start pointer and remove 1st element
	   	    		set.remove(s.charAt(start));
	   	    		start++;
	   	    	}else {
	   	    		// add to the list
	   	    		set.add(s.charAt(current));
	   	    		current++;
	   	    		max = Math.max(max, set.size());
	   	    	}
	   	    }
	        System.out.println(max);
	        
	     //optimised sol using map and also prints substring
	        
	        
	        //i is current index
	        //adding non repeating char to hashMap , if there is a repeating char 
	        //bring back the current index(i) next to the repeated char(already stored in hashMap).  
	        
	        HashMap<Character,Integer> characterMap = new HashMap<>();
	        int maxVal = 0,longestLengthSubString=0;
	        String result = "";
	        for(int i=0;i<s.length();i++) {
	        	char ch = s.charAt(i);
	        	if(characterMap.containsKey(ch)) {
	        		i = characterMap.get(ch);
	        		characterMap.clear();
	        	}else {
	        		characterMap.put(ch,i);
	        	}
	        	
	        	if(characterMap.size()>longestLengthSubString) {
	        		longestLengthSubString=characterMap.size();
	        		result=characterMap.keySet().toString();
	        	}
	        }
	        System.out.print(longestLengthSubString+"\t");
	        System.out.print(result);
	        
	        
	}

}
