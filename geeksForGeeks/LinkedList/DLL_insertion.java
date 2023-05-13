package LinkedList;

public class DLL_insertion {
	
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
	{
		Node newnode = new Node(data);
		
		if(head == null)
		{
			addAtFirst(data);
			return;
		}
		newnode.next = head;
		newnode.prev = null;
		head.prev = newnode;
		head = newnode;
	}
	public void append(int data)
	{
		Node newnode = new Node(data);
		
		if(head == null)
		{
			addAtFirst(data);
			return;
		}
		
		Node curr = head ,prev = null;;
		while(curr.next!=null)
		{
			curr = curr.next;
			prev=curr;
			
		}
		
		newnode.next = null;
	    curr.next = newnode;
	    newnode.prev = curr ;
	}
	
	void addAtFirst(int data)
	{
		Node newnode = new Node(data);
		newnode.prev = null;
		newnode.next = null;
		head = newnode;
		return;
	}
	
	public void InsertAfter(Node prev , int data)
	{
		
		if(prev == null)
		{
			 System.out.println("The given previous node cannot be NULL "); 
	            return; 
		}
		
		Node newnode = new Node(data);
		
		newnode.next = prev.next;
		prev.next = newnode;
		newnode.prev = prev;
		
		
		/* 7. Change previous of new_node's next node */
        if (newnode.next != null) 
        	newnode.next.prev = newnode;
		
		
		
	}
	public void print()
	{
		if(head == null) {
			System.out.println("list is empty!!");
			return;
		}
		
		Node temp = head, prev = null;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			prev = temp;
			temp = temp.next;
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DLL_insertion list = new DLL_insertion();
		list.push(10);
		list.push(20);
		list.push(5);
	//	list.InsertAfter(list.head, 222);
		list.print();

	}

}
