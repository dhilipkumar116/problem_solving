package searching_and_sorting;

public class quick_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = new int[] {10,3,1,5,7,2,9,8};
		quickSort(arr,0,arr.length-1);
		for(int val:arr) {
			System.out.print(val+" ");
		}
		
	}

	
	static void quickSort(int[] arr,int beg,int end) {
		
		if(beg<end) {
			int q = partion(arr,beg,end);
			quickSort(arr,beg,q-1);
			quickSort(arr,q+1,end);	
		}
		
	}
	
	static int partion(int[] arr,int beg,int end) {
		
		int j = beg-1;
		int pivot = arr[end];
		for(int i = beg; i<end;i++) {
			
			if(arr[i]<=pivot) {
				j++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			
		}
		
		j++;
		int temp = arr[j];
		arr[j] = arr[end];
		arr[end] = temp;
		
		return j;
	}
}
