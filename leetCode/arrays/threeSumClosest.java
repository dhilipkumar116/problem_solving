package arrays;
import java.util.Arrays;

public class threeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tgt = 1,k,j;
		int a[] = {-1,2,1,-4};
		int min =  Integer.MAX_VALUE;
		Arrays.sort(a);
		int res=0,sum,diff;
		for(int i=0;i<a.length-1;i++) {
			k=a.length-1;
			j = i+1;
			
			while(j<k) {
				sum = a[i]+a[j]+a[k];
				diff = tgt-sum;
				if(Math.abs(diff)<min) {
					res = sum;
					min = Math.abs(diff);
				}
				
				if(diff<0) {
					k--;
				}else if(diff>0) {
					j++;
				}else {
				    return;
				}
			}
		}
		
		System.out.print(res);		
	}

}
