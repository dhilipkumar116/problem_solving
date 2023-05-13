package searching_and_sorting;

public class heap_sort {

	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public void heapify(int[] arr, int root,int n) {
		
		int largest = root;
		int left = (2*largest)+1;
		int right = (2*largest)+2;
		
		
		//checking left is greater than root
		if(left<n&&arr[left]>arr[largest]) {
			largest = left;
		}
		//checking right is greater than root
		if(right<n&&arr[right]>arr[largest]) {
			largest = right;
		}
		
		if(largest!=root) {
			swap(arr,root,largest);
			//heapify rest of the tree
			heapify(arr,largest,n);
		}
		
	}
	
	public void sort(int[] arr, int size) {
		
		for(int i=(size/2)-1;i>=0;i--) {
			heapify(arr,i,size);
		}
		
		for(int i=size-1;i>=0;i--) {
			swap(arr,0,i);
			heapify(arr,0,i);
		}
		
	}
	
	public void print(int[] arr) {
		int size = arr.length;
		for(int i=0;i<size;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {121,10,30,57,36,17};
		int n = arr.length;
		heap_sort hp = new heap_sort();
		hp.sort(arr,n);
		hp.print(arr);

	}

}
