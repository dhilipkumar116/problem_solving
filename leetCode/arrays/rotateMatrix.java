package arrays;

public class rotateMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5};
		int idx =1;
		
		for(int i=0,j=idx;i<j;i++,j--) {
			swap(arr,i,j);
		}
		for(int i=idx+1,j=arr.length-1;i<j;i++,j--) {
			swap(arr,i,j);
		}
		for(int i=0,j=arr.length-1;i<j;i++,j--) {
			swap(arr,i,j);
		}
		for(int num:arr) {
			System.out.print(num+" ");
		}
	}
	
	private static void swap(int[] arr,int a,int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}
