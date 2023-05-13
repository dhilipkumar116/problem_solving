package Stacks;

import java.util.Stack;

public class reverseStack {
	
	
	static Stack<Character>  st = new Stack<Character>();
	
	static void reverse()
	{
		
		if(st.size()>0)
		{
			char a = st.peek();
			st.pop();
			reverse();
			InsetAtBottom(a);
			System.out.println(a);
		}
	}
	
	static void InsetAtBottom(char x)
	{
		if(st.isEmpty())
			st.push(x);
		else
		{
			char a = st.peek();
			st.pop();
			InsetAtBottom(x);
			st.push(a);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		st.push('1');
		st.push('2');
		st.push('3');
		st.push('4');
		reverse();
		System.out.println(st);
		
		

	}

}
