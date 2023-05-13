package arrays;

public class removeDuplicateFromSortedArray {

	public static void main(String[] args) {
		int arr[] = {0,0,1,1,1,2,2,3,3,4};
		int k=0;
		for(int i=1;i<arr.length;i++) {
			if(arr[k]!=arr[i]) {
				arr[++k]=arr[i];
			}
		}
		
		System.out.println(k+1);
	
		for(int a:arr) {
			System.out.print(a);
		}
	
	}

}
