package arrays;

import java.util.TreeSet;

public class maximumSubArraySum {

	public static void main(String[] args) {
//			sum	%2
//[1]		1	1
//[2]		2	0
//[3]		3	1
//[1,2]		3	1
//[2,3]		5	1
//[1,2,3]	6	0
		
		
			int[] a = {1,2,3};
			int m = 2;
			
		 	int n = a.length;
	        TreeSet<Long> set = new TreeSet<>();
	        long sum=0;
	        long max=0;
	        for(int i=0;i<n;i++){
	            sum = (sum+a[i])%m;
	            if(sum==m-1){
	    	        System.out.println(m-1);
	            }
	            Long nextHigher = set.higher(sum);
	            if(nextHigher!=null){
	                max = Math.max(max,(sum-nextHigher+m)%m);
	            }
	            set.add(sum);
	        }

	        
	        System.out.println(max);
		
		
	}

}
