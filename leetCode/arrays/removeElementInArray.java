package arrays;

public class removeElementInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {0,1,2,2,3,0,4,2};
		int val = 2;
		int p = 0;
		for(int i=0;i<a.length;i++) {
			if(a[i]!=val) {
				a[p] =a[i];
				p++;
			}else{
				continue;
			};
		}
		
		System.out.println(p);
		for(int aa:a) {
			System.out.print(aa);
		}

	}

}
