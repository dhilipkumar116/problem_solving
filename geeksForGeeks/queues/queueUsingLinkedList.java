package queues;

class ListNode{
	ListNode next;
	int val;
	ListNode(int val){
		this.val = val;
	}
}

public class queueUsingLinkedList {
	
	ListNode front=null,rear=null;
	
	private void enQueue(int val) {
		
		
		if(rear==null) {
			rear = new ListNode(val);
			front = rear;
		}else {
			rear.next = new ListNode(val);
			rear = rear.next;	
		}
		
	}
	
	private void deQueue() {
		if(front==null) {
			System.out.println("queue is empty");
			return;
		}
		if(front==rear) {
			front=null;
			rear=null;
			return;
		}
		front = front.next;
		
	}

	private void printQueue() {
		ListNode temp = front;
		while(temp!=null) {
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
		
	}
	
	public static void main(String[] args) {

		queueUsingLinkedList ql = new queueUsingLinkedList();	
		ql.enQueue(1);
		ql.enQueue(2);
		ql.enQueue(3);
		ql.enQueue(4);
		ql.enQueue(5);
		ql.enQueue(6);
		ql.deQueue();
		ql.deQueue();
		
		ql.printQueue();
		
	}

}
