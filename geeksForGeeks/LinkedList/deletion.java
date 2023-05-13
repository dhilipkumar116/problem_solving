package LinkedList;

public class deletion {
	
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
	
	public void push(int data) {
		
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
		
	}
	
	public void print() {
		
	   while(head !=null) {
		   System.out.println(head.data+" ");
		   head = head.next;
	   }
	}
	
	public void delete(int key) {
		
		// deletion at 	1st node
		if(head!=null && head.data==key) {
			head = head.next;
			return;
		}
		
	    Node temp=head ,prev = null;
		while(temp!=null && temp.data != key) {
			prev = temp;
			temp = temp.next;			
		}
		
		if(temp == null) {
			System.out.println("element not exist in the list");
			return;
		}
		
			prev.next = temp.next;
		
	}
	
	
	public void deleteAt(int position) {
		
		Node temp = head;
		
		if(position == 0) {
			head = temp.next;
			return;
		}
		
		for(int i=0;i<position-1;i++) {
			temp=temp.next;
		}
		
		if(temp==null || temp.next ==null)
			return;
		
		Node next = temp.next.next;
		temp.next = next;
	
	}
	
	public void deleteList() {
		head = null;
	}
	public static void main(String[] args)
	{
		deletion list = new deletion();
		list.push(10);
		list.push(20);
		list.push(30);
        list.deleteAt(1);
		list.print();
	}

}
