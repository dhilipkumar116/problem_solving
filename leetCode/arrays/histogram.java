package arrays;

public class histogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//largest rectangular sum 
		int[] arr = {1,2,3,1,2};
		
		bruteForce(arr);
	}
	
	private static void bruteForce(int[] arr) {

		int result=0;
		int n = arr.length;
		for(int i=0;i<n;i++) {
			int minHeight=arr[i];
			int area=arr[i];
			for(int j=i;j<n;j++) {
				minHeight = Math.min(minHeight, arr[j]);
				area = minHeight*(j-i+1);
			}
			result = Math.max(result,area);
		}
		System.out.println(result);
	}

}
