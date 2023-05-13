package String;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class permutation_countmethod {

	public static void main(String[] args) {
		
		
		char[] str = {'a','a','b'};
		TreeMap<Character,Integer> countmap = new TreeMap<>();
		for(char ch:str)
		{
			countmap.put(ch, countmap.getOrDefault(ch, 0)+1);
		}
		int[] count = new int[str.length];
		int index=0;
		for(Entry<Character,Integer> entry : countmap.entrySet())
		{
			count[index]= entry.getValue();
			index++;
		}
		
		char[] result = new char[str.length];
		
		permute1(str , count, result ,0);
		
				
	}
	
	public static void permute1(char[] str , int[] count , char[] result , int level)
	{
		if(level==result.length)
			System.out.println(result);
		
		for(int i=0;i<str.length;i++)
		{
			if(count[i]==0)
				continue;
			
			result[level]=str[i];
			count[i]--;
			permute1(str , count , result , level+1);
			count[i]++;
		}
		
	}
}

// same technique using map
//List<List<Integer>> result;
//Map<Integer,Integer> map;
//public List<List<Integer>> permuteUnique(int[] nums) {
//    
//    result = new ArrayList<>();
//    map = new HashMap<>();
//    for(int num:nums)
//        map.put(num,map.getOrDefault(num,0)+1);
//    permute(nums,new int[nums.length],0);
//    return result;
//}
//
//void permute(int[] nums,int[] curArr,int level){
//    
//    if(level==curArr.length){
//        List<Integer> list = new ArrayList<>();
//        for(int num:curArr)
//            list.add(num);
//        
//        result.add(list);
//        return;
//    }        
//    
//    for(int key : map.keySet()){
//        if(map.get(key)>0){
//            
//            curArr[level] = key;
//            map.put(key,map.get(key)-1);
//            permute(nums,curArr,level+1);
//            map.put(key,map.get(key)+1);
//        }
//    }
//}
