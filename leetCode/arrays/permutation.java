package arrays;

public class permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] num = {1,2,3};
		int r = num.length;
		permute(num,0,r);

	}
	
	static void permute(int[] num,int current,int end){
		if(current==end-1) {
			for(int a:num)
				System.out.print(a);
			System.out.print("\t");
		}
		
		for(int i=current;i<end;i++) {
			swap(num,current,i);
			permute(num,current+1,end);
			swap(num,current,i);
		}
	}
	
	static void swap(int[] num,int i,int j) {
		int temp = num[i];
		num[i]=num[j];
		num[j]=temp;
	}

}
