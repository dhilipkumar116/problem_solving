package trees;

public class segmentTree_RSQ {
	//segment tree is used for range sum Query
	// 0(n)-creating segment tree
	// 0(logn)-query
	// 0(logn)-updation
	
	
	public static void updateValueUtils(int[] st,
			int arrStart,int arrEnd,int i,int dif,int stPos) {
		
		if(arrStart>i||arrEnd<i) {
			return;
		}
		int mid=arrStart+(arrEnd-arrStart)/2;
		st[stPos] +=dif;
		if(arrStart!=arrEnd) {
			updateValueUtils(st,arrStart,mid,i,dif,2*stPos+1);
			updateValueUtils(st,mid+1,arrEnd,i,dif,2*stPos+2);
		}
		
	}
	
	public static void updateValue(int[] st,int[] arr, 
			int n,int i,int value) {
		int diff = value-arr[i];
		arr[i]=value;
		updateValueUtils(st,0,n-1,i,diff,0);
	}
	
	private static int getSum(int[] st,int sIdx,
			int sLeft,int sRight,int left,int right) {
	
		// total overlap
		if(left<=sLeft&&right>=sRight) {
			return st[sIdx];
		}
		
		// no overlap
		if(sRight<left||sLeft>right) {
			return 0;
		}
		
		//parital overlap
		int mid = sLeft+(sRight-sLeft)/2;
		return getSum(st,2*sIdx+1,sLeft,mid,left,right)
				+getSum(st,2*sIdx+2,mid+1,sRight,left,right);
		
	}
	
	

	
	private static void constructSt(int[] st,int idx,int l,int r,int[] arr) {
		if(l==r) {
			st[idx] = arr[l];
			return;
		}
		int mid = (l+r)/2;
		constructSt(st,2*idx+1,l,mid,arr);
		constructSt(st,2*idx+2,mid+1,r,arr);
		st[idx] = st[2*idx+1]+st[2*idx+2];
	}

	public static void main(String[] args) {
		

		int[] arr = new int[] {1, 3, 5, 7, 9, 11};
		int n = arr.length;
		int height = (int)Math.ceil((Math.log(n)/Math.log(2)));
		int sizeSt = (int)Math.pow(2, height+1)-1;
		int[] st = new int[sizeSt];
		constructSt(st,0,0,n-1,arr);
		System.out.print("printing array : ");
		for(int num:arr) {
			System.out.print(num+" ");
		}
		System.out.println();
		
		System.out.print("printing segment tree : ");
		for(int num:st) {
			System.out.print(num+" ");
		}
		System.out.println();
		
		System.out.print("range sum : "+getSum(st,0,0,n-1, 1,3));
		System.out.println();
		
		
		// updating idx 1 value ie: arr[1] = 10;
		updateValue(st,arr,n,1,10);
		System.out.println("after updating.... arr[1] = 10");
		System.out.print("range sum : "+getSum(st,0,0,n-1, 1,3));
		System.out.println();
		
	
		
	}

}
