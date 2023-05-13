package searching_and_sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class customSorting {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] arr = {3,30,35,5,9};
		
		
		 Arrays.sort(arr,new comp());
//		 Arrays.sort(arr, new Comparator<Integer>() {
//	         public int compare(Integer a, Integer b) {
//
//	            return a.compareTo(b);
//	         }
//	      });
//		
		
		for(int val:arr) {
			System.out.print(val+" ");
		}

	}
	
	class comp implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o1.compareTo(o2);
		}
		
		/*
		 * 	a.compareTo(b)
		 *	negative value: if a<b (a should appear first) 
		 *	zero if a=b
		 *	positive value: if a>b  (a should appear second)
		 *	 
		 * */
		
	}


}
