package LinkedList;

public class reversingList {
	
	 static Node head; 
	  
	    static class Node { 
	  
	        int data; 
	        Node next; 
	  
	        Node(int d) 
	        { 
	            data = d; 
	            next = null; 
	        } 
	    } 
	  
	    
	    
	    void printList(Node node) 
	    { 
	        while (node != null) { 
	            System.out.print(node.data + " "); 
	            node = node.next; 
	        } 
	    } 
	
	    
	    Node reverse(Node node) {
	    	
	    	Node prev = null , next = null;
	    	Node curr = head;
	    	
	    	while(curr!=null) {
	    		next = curr.next;
	    		curr.next = prev;
	    		prev = curr;
	    		curr = next;
	    	}
	    	
	    	// to change prev node to head ,++++++++++++we returning prev node
	    	node = prev;
	    	return node;
	    	
	    }
	    
	    Node recursive(Node curr , Node prev) {
	    	
	    	if(curr.next==null) {
	    		head = curr;
	    		curr.next= prev;
	    		return head;
	    	}
	    	
	    	Node next11 = curr.next;
	    	curr.next = prev;
	    	
	    	recursive(next11,curr);
	    	return head;
	    }
	
	
	public static void main(String[] args) {
		
		reversingList list = new reversingList();
		
		list.head = new Node(10);
		list.head.next = new Node(20);
		list.head.next.next = new Node(30);
		System.out.println("before reversing list");
		list.printList(head);
		System.out.println(""); 
		System.out.println("after reversing list");
//		list.printList(head = list.reverse(head));
		list.printList(head = list.recursive(head , null));

		
		
	}

}
