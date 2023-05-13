package LinkedList;

public class DLL_reversing {
	
	Node head;
	
	class Node{
		int data;
		Node next;
		Node prev;
		Node(int data)
		{
			this.data = data;
		}
	}
	
	public void push(int data)
	{
		Node newnode = new Node(data);
		
		newnode.next = head;
		newnode.prev = null;
		
		if(head!=null)
			head.prev  = newnode;
		
		head = newnode;
	}
	
	public void print()
	{
		Node prev = null , curr = head;
		while(curr!=null)
		{
			System.out.print(curr.data+" ");
			prev = curr ;
			curr = curr.next;
		}
		
		
	}
	
	public void reverse()
	{
		Node curr = head ;
		Node temp = null;
		
		while(curr!=null)
		{
			temp = curr.prev;
			curr.prev = curr.next;
			curr.next = temp;
			curr = curr.prev;
		}
		
		if(temp!=null)
		  head = temp.prev;
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DLL_reversing list = new DLL_reversing();
		list.push(10);
		list.push(20);
		list.push(30);
		System.out.println("list before reversing ");
		list.print();
		System.out.println(" ");
		list.reverse();
		System.out.println("list after reversing");
		list.print();

	}

}
