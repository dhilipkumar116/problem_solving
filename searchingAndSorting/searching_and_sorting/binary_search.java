package searching_and_sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class binary_search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[] {1,2,3,4,6,7};
		binary_search bs = new binary_search();
//		bs.binary_search(arr,6);
//		bs.method2();
//		bs.method3();
		bs.method4();
				
	}
	
	public int binary_search(int[] arr, int key) {
		  int low = 0, high = arr.length - 1;
		  int mid;

		  while (low <= high) {
		    mid = (low + high) / 2;
		    if (key == arr[mid]) {
		      return mid;
		    } else if (key < arr[mid]) { // left
		      high = mid - 1;
		    } else {  // right
		      low = mid + 1;
		    }
		  }
		  return -1;
	}

	
	
	public int binary_search_ceil(int[] arr, int key) {
//		if element not found return ceil element of the key 
		  int low = 0, high = arr.length - 1;
		  int mid;
		  int ans = -1;
		  while (low <= high) {
		    mid = (low + high) / 2;
		    if (key == arr[mid]) {
		      return mid;
		    } else if (key < arr[mid]) { // left
		        ans = mid;
		    	high = mid - 1;
		    	// right
		    } else {  
		      low = mid + 1;
		    }
		  }
		  return ans;
	}

	public int binary_search_floor(int[] arr, int key) {
//		if element not found return floor element of the key 
		  int low = 0, high = arr.length - 1;
		  int mid;
		  int ans = -1;
		  while (low <= high) {
		    mid = (low + high) / 2;
		    if (key == arr[mid]) {
		      return mid;
		    } else if (key < arr[mid]) { // left
		    	high = mid - 1;
		    } else {  
		      // left
		      ans = mid;
		      low = mid + 1;
		    }
		  }
		  return ans;
	}
	
	public void method4() {
		Integer arr[] = new Integer[] {1,2,4,6,8,11,17};
		int k = Collections.binarySearch(Arrays.asList(arr),7);
		System.out.print(k);
	}
	
}
