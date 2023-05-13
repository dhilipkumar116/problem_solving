package heaps;

public class min_heap {
	
   private int[] heap;
   private int size;
   private int maxsize;
   
   private static final int First=1;
   
   public min_heap(int maxsize) {
	   this.maxsize = maxsize;
	   heap = new int[maxsize + 1];
	   size=0;
	   heap[0] = Integer.MIN_VALUE;
	   
   }
   
   private int parent(int pos) {
	   return pos/2;
   }
   
   private int leftChild(int pos) {
	   return 2*pos+1 ;
   }
   
   private int rightChild(int pos) {
	   return 2*pos+2;
   }
   
   private boolean isLeaf(int pos) {
	   if(pos<=size && pos>=size/2)
		   return true;
	   return false;
   }
   
   private void swap(int fpos , int spos)
   {
	   int temp = heap[fpos];
	   heap[fpos] = heap[spos];
	   heap[spos] = temp;
   }
   
   private void minHeapify(int pos) {
	   
		   if (isLeaf(pos)) 
	           return;
		   
		   // If the node is a non-leaf node and greater 
	       // than any of its child 
		   if(heap[pos] > heap[leftChild(pos)] ||
				   heap[pos] > heap[rightChild(pos)])
		   {
			   // Swap with the left child and heapify 
               // the left child 
               if (heap[leftChild(pos)] < heap[rightChild(pos)]) { 
                   swap(pos, leftChild(pos)); 
                   minHeapify(leftChild(pos)); 
               } 
 
               // Swap with the right child and heapify 
               // the right child 
               else { 
                   swap(pos, rightChild(pos)); 
                   minHeapify(rightChild(pos)); 
               } 
			  		   
		   }
	   
   }

   private void print() {
	   for(int i=1 ; i<=size/2 ; i++) {
		   System.out.print(" PARENT : "+heap[i]+
				   " LEFT CHILD : "+heap[leftChild(i)]+
				   " RIGHT CHILD : "+heap[rightChild(i)]);
		   
		   System.out.println();
	   }
	   
	   
   }
   
   private void insert(int data) {
	   
	   if (size >= maxsize) { 
           return; 
       } 
       heap[++size] = data; 
       int current = size; 
 
       while (heap[current] < heap[parent(current)]) { 
           swap(current, parent(current)); 
           current = parent(current); 
       } 
   }
   
   // Function to build the min heap using 
   // the minHeapify 
   private void minHeap() {
	 
	   minHeapify(0);

   }
   
// Function to remove and return the minimum 
   // element from the heap 
   private int remove() {
	   int popped = heap[First];
	   heap[First] = heap[size--];
	   minHeapify(First);
	   
	   return popped;
	   
   }
   
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		min_heap minH = new min_heap(15);
		
//		minH.insert(5);
//		minH.insert(3);
//		minH.insert(17);
//		minH.insert(10);
//		minH.insert(84);
//		minH.insert(19);
//		minH.insert(6);
//		minH.insert(22);
//		minH.insert(9);
		
		minH.insert(4);
		minH.insert(1);
		minH.insert(9);
		minH.insert(2);
		minH.insert(3);
		
		minH.minHeap();
		
		minH.print();
		
	    //System.out.println("The Min val is " + minH.remove());
	    
	    //minH.print();

	}

}
