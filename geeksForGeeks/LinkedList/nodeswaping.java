package LinkedList;

public class nodeswaping {

	Node head;
	
	class Node{
		
		int data;
		Node next;
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	
	/* Function to swap Nodes x and y in linked list by 
    changing links */
 public void swapnode(int x, int y) 
 { 
     // Nothing to do if x and y are same 
     if (x == y) return; 

     // Search for x (keep track of prevX and CurrX) 
     Node prevX = null, currX = head; 
     while (currX != null && currX.data != x) 
     { 
         prevX = currX; 
         currX = currX.next; 
     } 

     // Search for y (keep track of prevY and currY) 
     Node prevY = null, currY = head; 
     while (currY != null && currY.data != y) 
     { 
         prevY = currY; 
         currY = currY.next; 
     } 

     // If either x or y is not present, nothing to do 
     if (currX == null || currY == null) 
         return; 

     // If x is not head of linked list 
     if (prevX != null) 
         prevX.next = currY; 
     else //make y the new head 
         head = currY; 

     // If y is not head of linked list 
     if (prevY != null) 
         prevY.next = currX; 
     else // make x the new head 
         head = currX; 

     // Swap next pointers 
     Node temp = currX.next; 
     currX.next = currY.next; 
     currY.next = temp; 
 } 
	
	
	public void push(int data) {
		 
		Node newnode = new Node(data);
		newnode.next = head;
		head = newnode;
		
	}
	
	public void print() {
		Node temp = head;
		while ( temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	public static void main(String[] args) {
		nodeswaping list = new nodeswaping();
		list.push(10);
		list.push(20);
		list.push(30);
		list.push(40);
		list.push(50);
		System.out.println("before swaping ");
		list.print();
		list.swapnode(50, 30);
		System.out.println("after swaping");
		list.print();
	}
}
