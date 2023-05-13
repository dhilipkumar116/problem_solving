package trees;

//range minimum query
public class segmentTree_RMQ {
	
	private void constructSt(int[] arr,int[] st,int l,int r,int idx) {
		if(l==r) {
			st[idx] = arr[l];
			return;
		}
		int mid = (l+r)/2;
		constructSt(arr,st,l,mid,2*idx+1);
		constructSt(arr,st,mid+1,r,2*idx+2);
		st[idx] = Math.min(st[2*idx+1], st[2*idx+2]);
		
//		for range maximum sum
//		st[idx] = Math.max(st[2*idx+1], st[2*idx+2]);
		
	}

	private int getQuery(int[] st,int qs,int qe,int l,int r,int idx) {
		
		// total overlap		
		if(qs<=l&&qe>=r) {
			return st[idx];
		}
		// no overlap		
		if(qs>r||qe<l) {
			return Integer.MAX_VALUE;
		}
		
		// partial overlap
		int mid = (l+r)/2;
		return (int)Math.min(getQuery(st,qs,qe,l,mid,2*idx+1),
				getQuery(st,qs,qe,mid+1,r,2*idx+2));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		segmentTree_RMQ st = new segmentTree_RMQ();
		int[] arr = {-1,3,4,0,2,1};
		int n = arr.length;
		int height = (int)Math.ceil(Math.log(n)/Math.log(2));
		int size = 2*(int)Math.pow(2, height)-1;
		int[] stArr = new int[size];
		st.constructSt(arr,stArr,0,n-1,0);
		
		System.out.println("printing given array:");
		for(int num:arr) {
			System.out.print(num+" ");
		}
		System.out.println();
		System.out.println("printing segment tree:");
		for(int num:stArr) {
			System.out.print(num+" ");
		}
		
//		query start
		int qs = 2;
//		query end
		int qe = 5;
		System.out.println();
		System.out.println("mininum value in the range"
				+ " ["+qs+","+qe+"] = "+st.getQuery(stArr,qs,qe,0,n-1,0));

	}

}
