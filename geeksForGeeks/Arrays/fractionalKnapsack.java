package Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class fractionalKnapsack {
	
	static class item{
		int val,wt;
		Double valRatio;
		@SuppressWarnings("deprecation")
		item(int val,int wt){
			this.val=val;
			this.wt=wt;
			valRatio = new Double((double)val/(double)wt);
		}
	}

	public static void main(String[] args) {

		int w=50;
		int[] values = {60,100,120};
		int[] weights = {10,20,30};
		item[] ratio = new item[values.length];
		for(int i=0;i<values.length;i++) {
			ratio[i] = new item(values[i],weights[i]);
		}
		
		Arrays.sort(ratio,new Comparator<item>() {
			@Override
			public int compare(item a,item b) {
				return b.valRatio.compareTo(a.valRatio);
			}
		});
		System.out.println(getResult(ratio,w));
		
	}
	
	
	public static double getResult(item[] ratio,int w) {
		
	
		double total=0d;
		
		for(int i=0;i<ratio.length;i++) {
			
			int wt = ratio[i].wt;
			int val = ratio[i].val;
			
			if(w-wt>=0) {
				w = w-wt;
				total +=val;
			}else {
				
				double fraction = (double)w/(double)wt;
				total +=val*fraction;
				w = (int)(w-(double)wt/fraction);
				break;
			}
			
		}
	
		
		return total;
		
	}

}
