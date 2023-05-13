package arrays;

public class waterTank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {0,1,0,2,1,0,1,3,2,1,2,1};
//		int[] num = {4,2,0,3,2,5};

		int res=0,sres=0;
		boolean reverse=false;
		int i=0;
		while(i<num.length-1) {
			
				int j=i;
				while(num[i]>=num[j] && j!=num.length-1) {
					sres = sres + (num[i]-num[j]);
					j++;
				}
				
				res =res +sres;	
				i=j;
				sres=0;
					

				for(int k=j;k<num.length;k++) {
					int max=  Math.max(num[j], num[k]);
					
					if(max==num[j]) {
						int reval=j;
						System.out.print(num[reval]);
					}
				}				

		}
		
	

	}

}
