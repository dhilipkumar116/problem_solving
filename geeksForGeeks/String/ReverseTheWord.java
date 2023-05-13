package String;

import java.util.Scanner;

public class ReverseTheWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the string");
		String s = sc.nextLine();
		
		
		String[]  words = s.split(" ");
		String reverseString = "";
		for(int i = words.length-1 ; i>=0 ; i--)
		{
			String reverseword =" " ;
			String word = words[i];
			for(int j = word.length()-1;j>=0 ;j--)
			{
				reverseword = reverseword+word.charAt(j);
			}
			
			reverseString = reverseString+reverseword+" ";
		}

		System.out.println(reverseString);
	}

}
