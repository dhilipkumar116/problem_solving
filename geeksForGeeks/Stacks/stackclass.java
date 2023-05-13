package Stacks;

import java.util.Stack;

public class stackclass {

	
	public static void stack_push(Stack stack)
	{
		for(int i=0;i<5;i++) {
			stack.push(i);
		}
	}
	
	public static void stack_pop(Stack stack)
	{
		System.out.println("poping.... ");
		for(int i =0 ;i<5;i++)
		{
			System.out.println(stack.pop()+" ");
		}
	}
	
	public static void stack_peek(Stack stack)
	{
		System.out.println("peek.... ");
		System.out.print(stack.peek()+" ");
		System.out.println(" ");
	}
	
	public static void stack_search(Stack stack , int element)
	{
		var a = stack.search(element);
		
	    if (a==-1)
			 System.out.println("element not found");
		else
			 System.out.println("element found in "+a);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack stack = new Stack();
		
		stack_push(stack);
		
		stack_search(stack , 0);
		
		stack_peek(stack);
		
		
		stack_pop(stack);

	}

}
