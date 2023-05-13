package Stacks;

import java.util.LinkedList;
import java.util.Queue;

public class stackusingOneQueue {
	
	
	Queue q = new LinkedList<Integer>();

	void push(int data)
	{
		int size = q.size();
		
		q.add(data);
		
		for(int i=0;i<size;i++)
		{
			q.add(q.remove());
		}
	}
	
	int top()
	{
		if(q.isEmpty())
		{
			return -1;
		}
		
		return (int)q.peek();
	}
	
	void pop()
	{
		if(q.isEmpty())
		{
			System.out.println("empty");
		}
		
		q.remove();
	}

	public static void main(String[] args) {
	 
		stackusingOneQueue st = new stackusingOneQueue();
		st.push(10);
		st.push(20);
		st.push(30);
		st.pop();
		System.out.println(st.top());

	}

}
