package priorityQ;

public class PQ_usingLinkedList {
	
	
	static class Node{
		int data;
		int priority;
		Node next;
		
		Node(int data , int priority)
		{
			this.data = data;
			this.priority =  priority;
			this.next = null;
		}
		
	}
	
	static int peek(Node head) {
		return head.data;
	}
	
	
	static Node pop(Node head) {
		Node temp = head;
		head = temp.next;
		return head;
	}

	
	static Node push(Node head, int data , int priority) {
		
		Node temp = new Node(data, priority);
		
		Node start = head;
		
		if(head.priority>priority)
		{
			temp.next = head;
			head = temp;
		}
		else
		{
			while(start.next.priority<priority && start.next != null) {
				start = start.next;
			}
			
			temp.next = start.next;
			start.next = temp;
			
		}
		
	   return head;
	}
	
	static int isEmpty(Node head) {
		return head == null ?1:0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PQ_usingLinkedList pq = new PQ_usingLinkedList();
		
	    Node head = new Node(10 , 1);
	    head = pq.push(head, 20, 0);
	    System.out.println(pq.peek(head));

	}

}
