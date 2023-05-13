package arrays;

import java.util.Arrays;

public class firstAndLastElementInSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,2};
		System.out.println(Arrays.toString(calculation(nums,1)));

	}
	
	static int[] calculation(int[] nums, int target) {
		
		 int v1=-1,v2=-1;
	       
	        int low = 0; 
	        int high = nums.length-1;
	        int mid = 0;
	        while(low<=high){
	            mid = low + (high-low)/2;
	            if(nums[mid]==target){
	                v1 = mid;
	                high = mid-1;
	            }else if(nums[mid]>target){
	                high = mid-1;
	            }else{
	                low = mid+1;
	            }
	        }
	        
	        low=0;high=nums.length-1;mid=0;
	        while(low<=high){
	            mid = low + (high-low)/2;
	            if(nums[mid]==target){
	                v2=mid;
	                low=mid+1;
	            }else if(nums[mid]>target){
	                high = mid-1;
	            }else{
	                low = mid+1;
	            }
	        }
	     
	        return new int[]{v1,v2};
	}

}
