package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.*;

public class threeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
		Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        
       
        for(int i=0;i<nums.length-2;i++){
             int k = nums.length -1;
             int j = i+1;
            while(j<k){
                
                if(nums[i]+nums[j]+nums[k]==0){
                    set.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    k--;
                    j++;

                }else if(nums[i]+nums[j]+nums[k]>0){
                    k--;
                }else{
                    j++;
                }
              
            }
        }
		
		
		System.out.print(set);
	}

}
