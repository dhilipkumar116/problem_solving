package arrays;

public class jumpGame2 {

	public static void main(String[] args) {
		
		int[] nums = {2,3,1,1,4};
		System.out.println(jump(nums));
		
	
	}
	
	//	i denotes the current index, i iterates upto canReachWithoutJumping
	//	and updates canReachWithoutJumping with maxReach. 
	 public static int jump(int[] nums) {
	       
		 int jump=0;
		 int maxReach = nums[0];
		 int canReachWithoutJumping = 0;
		 
		 for(int i=0;i<nums.length-1;i++) {
			 maxReach = Math.max(maxReach,i+nums[i]);
			 if(i==canReachWithoutJumping) {
				 jump++;
				 canReachWithoutJumping = maxReach;
			 }
		 }
		 return jump;
	    }
	 
	 
	 //can jump
	 public static boolean canJump(int[] nums) {
	      
	        if(nums.length==1){
	            return true;
	        }
	        boolean result = false;
	        int maxReach = 0;  // maximum value of index so far current index position
	        int canReach = 0;  // curren index maximum value(from 0 to maxReach) 
	        for(int i=0;i<nums.length-1;i++){
	            canReach = Math.max(canReach,i+nums[i]);
				// if current index reaches maxReach , maxReach will be updated.
	            if(i==maxReach){
	                maxReach = canReach;
					 
	                if(maxReach>=nums.length-1){
					//if maxReach is greater than length of the array->reached maxIndex
	                        return true;
	                }else{
							// if maxReach value is 0 , we cant move  further , so we cant reach maxIndex.
	                       if(nums[maxReach]==0){result = false;}
	                }                
	            }
	        }   
	        return result;
	    }
	


}
