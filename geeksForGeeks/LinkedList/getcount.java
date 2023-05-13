package LinkedList;



public class getcount {
	
Node head;
	
	public class Node
	{
	   Node next;
	   int data;
	   Node(int data)
	   {
		   this.data = data;
		   this.next= null;
	   }
	}

	// iterative
	public int getCount() {
		
		Node temp = head;
		
		int count=0;
		while(temp !=null) {
			count++;
			temp = temp.next;
		}
		
		return count;
	}
	
	
	// recursive
	public int getcountRec(Node node) {
		
		if(node == null)
			return 0;
		
		return 1+getcountRec(node.next);
	}
	
	public int getcountReccursive() {
		return getcountRec(head);
	}
	
	public void push(int data) {
		Node new_node = new Node (data);
		new_node.next=head;
		head = new_node;
	}
	
	public static void main(String[] args)
	{
		getcount list = new getcount();
		list.push(10);
		list.push(20);
		list.push(30);
		System.out.println("count "+ list.getcountReccursive());
		
	}
	
}
