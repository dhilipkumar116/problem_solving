package queues;

public class ADTarrayqueue {
	
	
	int front , rear;
	int size ;
	int capacity;
	int arr[];
	
	public ADTarrayqueue(int capacity)
	{
		this.capacity = capacity;
		front = this.size = 0;
		rear = -1;
		arr = new int[this.capacity];
	}

	void enqueue(int item)
	{
	    if(isFull())
	    	return;
	    
	    this.rear = (this.rear+1)%this.capacity;
	    this.arr[this.rear] = item;
	    this.size = this.size +1;
	    System.out.println(item +" enqueued");
	}
	
	int dequeue()
	{
		if(isEmpty())
			return Integer.MIN_VALUE;
		int item = arr[front];
		this.front = (this.front+1)%this.capacity;
		this.size = this.size-1;
		return item;
	}
	
	int Front()
	{
		if(isEmpty())
			return Integer.MIN_VALUE;
		return arr[front];
	}
	
	int Rear()
	{
		if(isEmpty())
			return Integer.MIN_VALUE;
		return arr[rear];
	}
	
	boolean isEmpty()
	{
		return (this.size==0);
	}
	
	boolean isFull()
	{
		return (this.size==this.capacity);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ADTarrayqueue que = new ADTarrayqueue(5);
		que.enqueue(10);
		que.enqueue(20);
		que.enqueue(30);
		que.enqueue(30);
		que.enqueue(30);
		System.out.println("dequeue " +que.dequeue()); 
		System.out.println("dequeue " +que.dequeue()); 
		System.out.println("dequeue " +que.dequeue()); 
		System.out.println("dequeue " +que.dequeue()); 
		System.out.println("dequeue " +que.dequeue()); 
		
		 
        System.out.println("Front item is " +  
                               que.Front()); 
           
        System.out.println("Rear item is " +  
                                que.Rear()); 
		

	}

}
