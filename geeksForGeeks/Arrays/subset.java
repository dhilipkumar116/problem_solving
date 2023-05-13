package Arrays;

import java.util.ArrayList;

public class subset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {1,2,3,4,5};
		ArrayList ans=new ArrayList();
		for(int k=1;k<=a.length;k++){
		for(int i=0;i<=a.length-k;i++){
		String s="";
		for(int j=i;j<i+k;j++)
		s+=a[j];
		if(s!="")
		ans.add(Integer.parseInt(s));
		}
		}
		System.out.println(ans);
		

	}

}
