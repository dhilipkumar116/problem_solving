package arrays;

public class searchInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {4,5,6,7,0,1,2};
		
		System.out.println(search(arr,1));

	}
	
	
	  public static int search(int[] nums, int target) {
	      
		  
		  int i=0,pivot=0;
		  int j=nums.length-1;
		  while(i<j) {
			  if(nums[i]>nums[j]) {
				 i++;
			  }else {
				 j--;
			  }
		  }
		  
		  pivot = i;
		  
		  if(nums[pivot]==target) {
	        	return pivot;
	        }
	      
		  int low,high;
		  if(pivot==0) {
			  low = pivot;
			  high = nums.length-1;
		  }else if(pivot==nums.length-1) {
			low =0;
			high = pivot-1;
		  }else if(nums[nums.length-1]<target && pivot!=0 && pivot!=nums.length-1) {
			  low = 0;
			  high = pivot-1;
		  }else {
			  low = pivot;
			  high= nums.length-1;
		  }
	
	        int mid=0;	
	        
	       
	        while(low<=high) {
				mid = low + (high - low)/2;
				if(nums[mid]==target) {
					
					return mid;
				}
				else if(target<nums[mid]) {
					high=mid-1;
				}
				else {
					low=mid+1;
				}	
			}
	        
	        return -1;
	    }

}
