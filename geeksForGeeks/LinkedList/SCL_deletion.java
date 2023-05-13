package LinkedList;

import LinkedList.SCL_insertion.Node;

public class SCL_deletion {

	static Node last;
	static Node head;
	
	static class Node{
		Node next;
		int data;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	public void removeFirst()
	{
		
		Node temp = last.next;
		
		if(head == temp)
		{		
			 last.next = null;
			 last= null;
			 return;
		}
		   
		
		last.next = temp.next;
		head = temp.next;
		return;
		
		
	}
	
	public void removeLast()
	{
		
		Node temp = last.next;
		if(head == temp)
		{		
			 last.next = null;
			 last= null;
			 return;
		}
		
		
		
		Node prev= null;
		do
		{
			
			prev = temp.next;
			
		}while(prev.next != last);
		
		prev.next = last.next;
		last = prev;
		return;
		
		
	}
	
	public void removeAt(int data)
	{
		
		Node curr = last.next;
		Node prev = null;
		
	
		while(curr.data!=data)
		{
			
			prev = curr;
			curr = curr.next;
			
		}
		
		prev.next = curr.next;
		
		
	}
	
	public void print()
	{

		if(last == null) {
			System.out.println("list is empty !!");
			return;
		}
		Node p = last.next;
		do
		{
			System.out.print(p.data+" ");
			p = p.next;
		}while(p!=last.next);
	}
	
	public void addFirst(int data) {
		
		Node newnode = new Node(data);
		
	     if(last == null)
	     {
	    	 last = newnode;
	    	 newnode.next = last;
	    	 head = last;
	    	 return;
	     }
	     
	     newnode.next = last.next;
	     last.next = newnode;
	}
	public static void main(String[] args) {
		
		SCL_deletion list = new SCL_deletion();
		
		list.addFirst(10);
		list.addFirst(12);
		list.addFirst(33);
		list.removeAt(10);
		list.print();

	}

}
