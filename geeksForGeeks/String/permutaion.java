package String;

import java.util.Arrays;
import java.util.Scanner;

public class permutaion {

	public static void main(String[] args) {
	
		permutaion dm = new permutaion();
	    String word = "123 ";
	    dm.permute(word,0,word.length()-1);
	    

	}

	
	void permute(String str,int l,int r)
	{
		if(l==r) 
			System.out.println(str);
		else
		for(int i=l;i<=r;i++)
		{
			str = swap(str,l,i);
			permute(str,l+1,r);
			str = swap(str,l,i);
		}
	}
	
	String swap(String b, int i,int j)
	{
		char[] tempArr =b.toCharArray();
		char temp=tempArr[i];
		tempArr[i]=tempArr[j];
		tempArr[j]=temp;
		
		return String.valueOf(tempArr);
		
	}
	

	

}
