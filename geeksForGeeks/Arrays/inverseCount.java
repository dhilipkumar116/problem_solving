package Arrays;

public class inverseCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//inverting count is array where i<j and also
		// nums[i]>nums[j]
		
		
		int[] arr = {2,4,3,5,1};
		int n = arr.length;
		System.out.println(mergeSort(arr,n));

	}
	
	
	private static int mergeSort(int[] arr,int len) {
		
		int inverseCount=0;
		
		if(len<2) {return inverseCount;}
		
		int mid = len/2;
		int[] L = new int[mid];
		int[] R = new int[len-mid];
		
		for(int i=0;i<mid;i++) {
			L[i] = arr[i];
		}
		for(int i=mid;i<len;i++) {
			R[i-mid] = arr[i];
		}
		
		inverseCount +=mergeSort(L,mid); 
		inverseCount +=mergeSort(R,len-mid); 
		inverseCount +=merge(arr,L,R,mid,len-mid); 
		
		return inverseCount;
		
	}
	
	private static int merge(int[] arr,int[] L,int[] R,int Lend,int Rend) {
		
		int count=0;
		int k=0;
		int i= 0;
		int j= 0;
		
		while(i<Lend&&j<Rend) {
			if(L[i]<=R[j]) {
				arr[k++] = L[i++];
			}else {
				arr[k++] = R[j++];
				count += (Lend-i);				
			}
		}
		
		while(i<Lend) {
			arr[k++] = L[i++];
		}
		while(j<Rend) {
			arr[k++] = R[j++];
		}
		
		return count;
	}

}
