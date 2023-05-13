package searching_and_sorting;

public class merge_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		
		int arr[] = new int[] {1,7,3,8,9,23,55,34,23,44};
		MergeSort ms = new MergeSort();
		ms.mergesort(arr,arr.length);
		
		for(int i :arr) {
			System.out.print(i+" ");
		}
		
	}
	

}

class MergeSort{
	
	void mergesort(int[] arr,int length) {
		
		if(length<2) return;

		int mid = length/2;
		int[] left = new int[mid];
		int[] right = new int[length-mid];
		for(int i=0;i<mid;i++) left[i] = arr[i];
		for(int i=mid;i<length;i++) right[i-mid] = arr[i];
		mergesort(left,mid);
		mergesort(right,length-mid);
		merge(arr,left,right,mid,length-mid);
	}
	
	
	void merge(int[] arr,int[] left,int[] right,int Lend, int Rend) {
		
		int i=0,j=0,k=0;
		while(i<Lend&&j<Rend) {
			if(left[i]<=right[j]) {
				arr[k++] = left[i++];
			}else {
				arr[k++] = right[j++];
			}
		}
		while(i<Lend) {
			arr[k++] = left[i++];
		}
		while(j<Rend) {
			arr[k++] = right[j++];
		}
		
	}
	
}
























