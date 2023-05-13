package arrays;
import java.util.*;

public class permutationWithCount {

	public static void main(String[] args) {
		
		
		// main idea is count the redundant character and store it in different array.
		// add char to curList and decrement count repeat the this step until count become 0.
		
		
		char[] inp = {'A','A','B','C'};
		Map<Character,Integer> countMap = new TreeMap<Character,Integer>();
		for(char c:inp) {
			if(countMap.containsKey(c)) {
				countMap.put(c,countMap.get(c)+1);
			}else {
				countMap.put(c,1);
			}
		}
		char[] arr = new char[countMap.size()];
		int[] count = new int[countMap.size()];
		int index=0;
		for(Character key:countMap.keySet()) {
			arr[index] = key;
			count[index++] = countMap.get(key);
		}
		char[] curList = new char[inp.length];
		findPermutation(arr,count,curList,0,inp.length);

	}
	static void findPermutation(char[] arr,int[] count,
			char curList[],int level,int maxLength) {
		
		if(maxLength==level) {
			for(char c:curList) {
				System.out.print(c);
			}
			System.out.println();
			return;
		}

		for(int i=0;i<arr.length;i++) {
			if(count[i]==0) continue;

				curList[level] = arr[i];
				count[i]--;
				findPermutation(arr,count,curList,level+1,maxLength);
				count[i]++;
	    }

  }
}
























