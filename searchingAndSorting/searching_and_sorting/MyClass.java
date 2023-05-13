package searching_and_sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MyClass {

	static int[][] dp;
	static int mid = 5;
	static int[] nums = {1,1,1,1,1};
	static int target = 3;
	
	public static void main(String[] args) {
	
		MyClass mc =  new MyClass();
		
		int[][] intervals = {{0,12},{5,10},{7,13},{8,14},
				{15,30},{15,30},{15,30},{15,30},{15,30}
		};
		
		int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        
        int i=0;
        for(int[] interval : intervals) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
            i++;
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        int rooms = 0;
        int endIdx = 0;
        for(int startIdx = 0; startIdx < n; startIdx++) {
            if( start[startIdx] < end[endIdx] ) {
                rooms++;
            }else{
                endIdx++;
            }
        }

		System.out.print(rooms);
	}
}
