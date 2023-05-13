package LinkedList;



public class insertion {
	

	Node head;
	Node tail;
	
	class Node{
		public int data;
		public Node next;
		
		Node(int data)
		{
			this.data=data;
			this.next=null;
		}
	}
	
	
	public void addFirst(int data)
	{
		Node new_node = new Node(data);
		new_node.next = head ;
		head = new_node;
	}
	
	public void inserAfter(Node pre_node,int data)
	{
		if(head==null)
			System.out.println("list is already empty ! , data cannot be added....");
		if(pre_node == null)
		{
			  System.out.println("The given previous node cannot be null"); 
	            return; 
		}
		Node new_node = new Node(data);
		
		new_node.next = pre_node.next;
		pre_node.next = new_node;
	}
	
	public void append(int data)
	{
		Node new_node = new Node(data);
		
		if(head == null) {
			head = new_node;
			return;
		}
		
	
		tail = head;
		while(tail.next!=null) {
			tail = tail.next; 
		}
		tail.next =new_node;
		new_node.next=null;
		return;
	}
	public void print()
	{
		
		Node curr = head;
		while(curr !=null) {
			System.out.println(curr.data+" ");
			curr=curr.next;
		}
	}
	
	    public static void main(String[] args) 
	    { 
	        /* Start with the empty list */
	       // LinkedList  = new LinkedList(); 
	        insertion list = new insertion();
	        list.append(6);
	        list.addFirst(7);
	        list.addFirst(1);
	        list.append(4);
	        list.inserAfter(list.head, 100);
	        list.print();
	        
	  
	        
	    } 

}
