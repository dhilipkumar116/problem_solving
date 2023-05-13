package Stacks;

import java.util.LinkedList;
import java.util.Queue;

public class stackusingTwoQueue {

	Queue q1 = new LinkedList<>();
	Queue q2 = new LinkedList<>();
	
	int curr_size ;
	void queueUsingStack()
	{
		curr_size = 0;
	}
	
	void REMOVE()
	{
		if(q1.isEmpty())
			return;
		
		while(q1.size()!=1)
		{
			q2.add(q1.peek());
			q1.remove();
		}
		
		q1.remove();
		curr_size--;
		
		Queue q = q1;
		q1 = q2;
		q2 = q;
	}
	
	
	void ADD(int x)
	{
		q1.add(x);
		curr_size++;
	}
	
	int top()
	{
		if(q1.isEmpty())
			return -1;
		
		while(q1.size()!=1)
		{
			q2.add(q1.peek());
			q1.remove();		
		}
		
		int temp = (int) q1.peek();
		
		q1.remove();
		Queue q = q1;
		q1 = q2;
		q2 = q;
		return temp;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		stackusingTwoQueue stack = new stackusingTwoQueue();
		stack.ADD(10);
		stack.ADD(20);
		stack.ADD(30);
		System.out.println("top element : "+stack.top());
		stack.REMOVE();
		System.out.println("top element : "+stack.top());

		

	}

}
