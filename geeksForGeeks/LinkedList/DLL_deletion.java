package LinkedList;

import LinkedList.DLL_insertion.Node;

public class DLL_deletion {
	
Node head;

	
	class Node{
		int data;
		Node next;
		Node prev;
		
		Node(int data){
			this.data = data;
		}
	}

	
	public void push(int data)
	{ /* 1. allocate node  
		    * 2. put in the data */
	    Node new_Node = new Node(data); 
	  
	    /* 3. Make next of new node as head and previous as NULL */
	    new_Node.next = head; 
	    new_Node.prev = null; 
	  
	    /* 4. change prev of head node to new node */
	    if (head != null) 
	        head.prev = new_Node; 
	  
	    /* 5. move the head to point to the new node */
	    head = new_Node; 
	}
	

	
	public void deletNode(Node headref ,Node dele)
	{
		if(head == null || dele == null)
			return;
		
		if(dele == head)
		{
			head  = dele.next;
			return;
		}
		
		if(dele.next!=null)
			dele.next.prev = dele.prev;
		
		if(dele.prev!=null)
			dele.prev.next= dele.next;
		
		return;
		
		
	}
	
	public void print()
	{
		if(head == null) {
			System.out.println("list is empty!!");
			return;
		}
		
		Node temp = head;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DLL_deletion list = new DLL_deletion();
		list.push(10);
		list.push(20);
		list.push(30);
		list.deletNode(list.head, list.head.next);
		list.print();
		

	}

}
