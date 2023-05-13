package strings;
import java.util.*;

public class phoneNumCombinaton {

	public static void main(String[] args) {
		// the main idea is we need to loop through digits and get corresponding mapping string
		// we need to get 1st char from 1st mapping string and increment to the 1st char from 2nd 
		// mapping string. 
		// if stored(curCombination) char length == digits length (we found 1st combination).

		
		
		String digits = "23";
		//mapping strings
		String[] mapping = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> list = new ArrayList<>();
        
        if(digits.length()==0){
             System.out.print(list);;
        }
        findLetterCombinations(digits,list,0,"",mapping);
		System.out.println(list);
	}

		static void findLetterCombinations(String digits,List<String> list,int index,
				String curCombination,String[] mapping){
			//if index value reaches 
        if(index==digits.length()){
            list.add(curCombination);
            return;
        }
        String letter = mapping[digits.charAt(index)-'0'];
        for(int i=0;i<letter.length();i++){
        	findLetterCombinations(digits,list,index+1,curCombination+letter.charAt(i),mapping);
        }
    }
}
