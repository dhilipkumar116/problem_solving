package Stacks;

public class TwoStacksinOneArray {
	
	
	int size;
	int top1 , top2;
	int[] arr;

	TwoStacksinOneArray(int sizeofarr)
	{
		size = sizeofarr;
		top1=-1;
		top2=size;
		arr = new int[size];
	}
	
	
	
	void push1(int item)
	{
	  
	   if(top1<top2-1) {
           arr[++top1] = item; 
	   }
	   else {
		   System.out.println("stack 1 is full....");
		   return;
	   }
		   
	}
	
	 void push2(int item)
	 {
		 if(top1<top2-1)
			 arr[--top2] = item;
		 else
			 System.out.println("stack 2 is full....");
	 }
	
    Integer pop1()
    {
    	if(top1 >= 0)
    	{
    		int x= arr[top1];
    		--top1;
    		return x;
    	}
    	else
    		 System.out.println("stack 1 is empty....");
    	
    	return null;
    }
    
    Integer pop2()
    {
    	if(top2 <= size)
    	{
    		int x = arr[top2];
    		++top2;
    		return x;
    	}
    	else
    		 System.out.println("stack 2 is empty....");
    	
    	return null;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoStacksinOneArray stack = new TwoStacksinOneArray(3);
		stack.push1(10);
		stack.push1(20);
		stack.push2(30);
		
		System.out.println(stack.pop1());
		System.out.println(stack.pop1());
//		System.out.println(stack.pop1());
		System.out.println(stack.pop2());
//		System.out.println(stack.pop2());
//
	}

}
