package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class combinationUnique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {10,1,2,7,6,1,5};
		int target = 8;
		
		Arrays.sort(nums);
		
		
	Set<List<Integer>> res = new HashSet<>();
	
		System.out.println(
				findCombination(nums,target,res,new ArrayList<>(),0)
				);

	}
	
	static Set<List<Integer>> findCombination(int[] nums,int target,Set<List<Integer>> res
			,List<Integer> curr,int index){
		
		if(target==0) {
			res.add(new ArrayList<>(curr));
		}
		
		for(int i=index;i<nums.length;i++) {
			if(target-nums[i]>=0) {
				curr.add(nums[i]);
				findCombination(nums,target-nums[i],res,curr,i+1);
				curr.remove(curr.size()-1);
			}
		}
		return res;
	}

}
