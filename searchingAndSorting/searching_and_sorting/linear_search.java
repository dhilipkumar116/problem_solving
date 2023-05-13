package searching_and_sorting;

import java.util.Scanner;

public class linear_search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] {22,41,3,1,5,66,36};
		Scanner sc = new Scanner(System.in);
		System.out.println("enter no to be search...");
		int val = sc.nextInt();
		sc.close();
		for(int i=0;i<arr.length;i++) {
			if(val==arr[i]) {
				System.out.println("element present..."+arr[i]);
			}
		}

	}

}
