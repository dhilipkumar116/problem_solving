package trees;

public class fenwickTree {

	// fenwick tree == binary indexed tree
	// to find prefix sum array in 0(log n) time
	// update - 0(log n)
	// create - 0(n log n)
	
	static int[] BITree;
	
	private static int getNext(int index) {
		return index+(index&-index);
	}
	
	private static int getParent(int index) {
		return index-(index&-index);
	}
	
	private static void createBITree(int[] arr) {
		
		int n = arr.length;
		for(int i=1;i<=n;i++) {
			updateBITree(i,arr[i-1]);
		}
		
	}
	
	private static void updateBITree(int index,int val) {
		index = index+1;
		int BITLen = BITree.length;
		while(index<BITLen) {
			BITree[index] +=val;
			index = getNext(index);
		}
	}
	
	private static int getSum(int index) {
		index = index+1;
		int sum=0;
		while(index>0) {
			sum +=BITree[index];
			index = getParent(index);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		
		int[] arr = new int[] {3,2,-1,6,5,4,-3,3,7,2,3};
		int n = arr.length;
		BITree = new int[n+1];
		createBITree(arr);
		
		System.out.println("given array:");
		for(int num:arr) {
			System.out.print(num+" ");
		}
		System.out.println();
		System.out.println("BIT representation:");
		for(int num:BITree) {
			System.out.print(num+" ");
		}
		System.out.println();
		
		int index=5;
		System.out.println("sum of array till the index : "+index);
		System.out.println("sum = "+getSum(index));
		
		int updateValue = 9;
		updateBITree(3,updateValue-arr[3]);
		System.out.println("after updating value at index : "+3);
		System.out.println("sum = "+getSum(4));
		

	}

}
