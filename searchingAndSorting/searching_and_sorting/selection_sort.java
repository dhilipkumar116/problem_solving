package searching_and_sorting;

import java.util.Stack;

public class selection_sort {
	
//	The selection sort algorithm sorts an array by repeatedly 
//	finding the minimum element (considering ascending order) 
//	from unsorted part and putting it at the beginning. 
//	
//	The algorithm maintains two subarrays in a given array.
//	1) The subarray which is already sorted. 
//	2) Remaining subarray which is unsorted.
//	In every iteration of selection sort, the minimum 
//	element (considering ascending order) from the unsorted 
//	subarray is picked and moved to the sorted subarray. 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {12,3,4,5,6,5,3,74,65,23,21};
		int n = arr.length;
		
		for(int i=0;i<n-1;i++) {
			
			int minIdx=i;
			for(int j=i+1;j<n;j++) {
				if(arr[j]<arr[minIdx]) {
					minIdx = j;
				}
			}
			int temp = arr[i];
			arr[i] =  arr[minIdx];
			arr[minIdx] = temp;
			
		}
		
		
		for(int num:arr) {
			System.out.print(num+" ");
		}

	}

}
