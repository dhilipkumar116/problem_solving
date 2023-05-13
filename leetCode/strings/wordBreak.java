package strings;
import java.util.*;

public class wordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String s = "catsadog";
		String[] words = {"cat", "cats", "and", "sand", "dog"};
		List<String> wordDict = new ArrayList<>(Arrays.asList(words));
		
	
		List<String> res = helper(s, wordDict, new HashMap<>());

		System.out.println(res);

	}
	
	 private static List<String> helper(String s, List<String> words, Map<String, List<String>> memo){
	        List<String> result = new ArrayList<>();
	        if (s.length() == 0){
	            result.add("");
	            return result;
	        }
	        if (memo.containsKey(s))
	            return memo.get(s);
	        for (String word : words){
	            if (s.startsWith(word)){
	                String substring = s.substring(word.length());
	                List<String> substrings = helper(substring, words, memo);
	                //System.out.println(substrings);
	                for (String str : substrings){
	                    String optionalSpace = str.isEmpty() ? "" : " ";
	                    result.add(word + optionalSpace + str);
	                }
	            }
	        }
	        memo.put(s, result);
	        return memo.get(s);
	    }

}

