package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class firstMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums= {1,2,0};
		int r=nums.length-1;
		Arrays.sort(nums);
		System.out.println(findNumber(nums,r));
	
	}
	
	static int findNumber(int[] nums,int r) {
		
		//using hashset
		   	Arrays.sort(nums);
	        Set<Integer> set = new HashSet<>();
	        int MIN=0;
	        for(int i : nums){
	            if(i>0){
	                MIN = Math.min(MIN,i);
	                set.add(i);
	            }   
	        }
	        int res = MIN+1;
	        while(set.contains(res)){
	            res++;
	        }	        
	        return res;
	}

}
