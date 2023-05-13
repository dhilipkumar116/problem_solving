package arrays;

public class nextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {9,1,2,4,3,1,0};

        if(nums.length<=1){
            return;
        }
        
        int index = nums.length-2;
        while(index>=0 && nums[index]>=nums[index+1]){
            index--;
        }
        
        if(index<0){
            reverse(nums,0);
            return;
        }
        index++;
        int indexToSwap = index;
        int element = nums[index-1];
        for(int i=index;i<nums.length;i++){
            if(nums[i]>element){
                indexToSwap=i;
            }
        }
        
        swap(nums,index-1,indexToSwap);
        reverse(nums,index);
       
    
    
	}
	
	  static void swap(int[] nums , int i , int  j){
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }
	    
	   static void reverse(int[] nums , int j){
	        int r = nums.length-1;
	        while(j<r){
	            swap(nums,j++,r--);
	        }
	    }
}
