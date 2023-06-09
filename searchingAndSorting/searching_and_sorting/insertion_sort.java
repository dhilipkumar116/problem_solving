package searching_and_sorting;

public class insertion_sort {
	
//	Insertion sort is a simple sorting algorithm that works similar
//	to the way you sort playing cards in your hands. 
//	The array is virtually split into a sorted and an unsorted part. 
//	Values from the unsorted part are picked and placed at the 
//	correct position in the sorted part.
	
//	Algorithm 
//	To sort an array of size n in ascending order: 
//	1: Iterate from arr[1] to arr[n] over the array. 
//	2: Compare the current element (key) to its predecessor. 
//	3: If the key element is smaller than its predecessor, 
//	compare it to the elements before. Move the greater elements 
//	one position up to make space for the swapped element.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = new int[] {3,5,1,7,4,2,9};
		int j;
		for(int i=1;i<arr.length;i++) {
			j=i;
			int key =  arr[i];
			while(j>0 && arr[j-1]>key) {
				arr[j]=arr[j-1];
				j--;
			}
			arr[j]=key;
		}
		for(int val:arr) {
			System.out.print(val+" ");
		}

	}

}
