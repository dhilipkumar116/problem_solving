package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationOfArrayAndTarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {2,3,6,7};
		int target = 7;
		List<List<Integer>> res =new  ArrayList<>();
		List<Integer> curList = new ArrayList<>();
		System.out.println(
				findCombination(nums,target,res,curList,0)
				);
		

	}
	
	static List<List<Integer>> findCombination(int[] nums, int target ,
			List<List<Integer>> res,List<Integer> curr,int index)
	{
		
		if(target==0) {
			res.add(new ArrayList<>(curr));
		}
		
		for(int i=index;i<nums.length;i++) {
			if(target-nums[i]>=0) {
				curr.add(nums[i]);
				findCombination(nums,target-nums[i],res,curr,i);
				curr.remove(curr.size()-1);
			}
		}
		
		
		return res;
		
	}
		
	
}
