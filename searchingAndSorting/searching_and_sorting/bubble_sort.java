package searching_and_sorting;

public class bubble_sort {

	// time complexity - 0(n^2)
	// idea::
	//compare each of adjacent elements and swap if element is greater than next element
	// we will get sorted array from right to left
	
//	Bubble Sort is the simplest sorting algorithm that works 
//	by repeatedly swapping the 
//	adjacent elements if they are in wrong order.
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] arr = {2,4,8,1,23,23,1,1,3,4,3,1,4,31,4,34,1,23,4,1234};
		
		int n = arr.length;
		
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		System.out.println("after sorting:");
		for(int num:arr) {
			System.out.print(num+" ");
		}
	
	}
	


}
