package arrays;

public class maxSumSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		
		// using kadanes algo (comparing currentMax with the max)
		// maxEnding is the current index
		// maxSoFar is the max value before maxEnding index
		int l = nums.length;
		int maxEnding =0;
		int maxSoFar = Integer.MIN_VALUE;
		for(int i=0;i<l;i++) {
			maxEnding=maxEnding+nums[i];
			if(maxEnding<nums[i]) {
				maxEnding = nums[i];
			}
			if(maxEnding>maxSoFar) {
				maxSoFar = maxEnding;
			}
		}
		System.out.println(maxSoFar);
		
		
		//brute force
		int res = Integer.MIN_VALUE;
		for(int i=0;i<l;i++) {
			int sum = 0;
			for(int j=i;j<l;j++) {
				for(int k=i;k<=j;k++) {
					sum = sum +nums[k];
				}
				res = Math.max(res , sum);
				sum = 0 ;
			}
		}
		System.out.println(res);
	}

}
