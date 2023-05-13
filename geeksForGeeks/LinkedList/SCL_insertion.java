package LinkedList;

public class SCL_insertion {
	
	Node last;
	
	class Node{
		
		Node  next;
		int data;
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}

	public void addFirst(int data) {
		
		Node newnode = new Node(data);
		
		Node temp= newnode;
		// if list is empty
		if(last == null) {
			last = temp;
			temp.next = last;
			return;
		}
		
		newnode.next = last.next;
		last.next = newnode;
		
	}
	
	public void addLast(int data) {
		
		Node newnode = new Node(data);
		
		Node temp= newnode;
		// if list is empty
		if(last == null) {
			last = temp;
			temp.next = last;
			return;
		}
		
		
		newnode.next = last.next;
		last.next = newnode;
		last = newnode;
		
	}
	
	public void print() {
	
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
	
	public void addAfter(int after , int data) {
		
		Node p = last.next;
		do
		{
			Node temp = new Node(data);
			if(p.data == after) {
			
				temp.next = p.next;
		 		p.next=temp;
			
			}
			p = p.next;
			
			
		}while(p!=last.next);
		 System.out.println(after + " not present in the list."); 
		return;
	}
	
	public int getCount() {
		
		Node head = last.next;
		int count =0;
		do
		{
			count ++;
			head = head.next;
		}while(head!=last.next);
		
		return count;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SCL_insertion list = new SCL_insertion();
		list.addFirst(10);
		list.addFirst(20);
		list.addFirst(30);
		list.addLast(40);
		list.print();
		System.out.println(" ");
		System.out.println(list.getCount());

		
	}

}
