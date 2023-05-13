package heaps;

public class max_heap {
	
		int[] heap;
		int size=-1;
		int heapSize;
		public max_heap(int heapSize){
			this.heapSize = heapSize;
			this.heap = new int[heapSize+1];
			heap[0] = Integer.MIN_VALUE;
		}
		
		public int getParent(int child) {
			return child/2;
		}
		
		public int getLeft(int root) {
			return (2*root)+1;
		}
		
		public int getRight(int root) {
			return (2*root)+2;
		}
		
		public void swap(int i,int j) {
			int temp = heap[i];
			heap[i]=heap[j];
			heap[j]=temp;
		}
		public void insert(int val) {
			heap[++size]=val;
			
			int current = size;
			while(heap[current]>heap[getParent(current)]) {
				swap(current,getParent(current));
				current = getParent(current);
			}
		}
		
		public boolean isLeaf(int pos) {
			
			if(pos>=size/2&&pos<=size) {
				return true;
			}
			return false;
		}
		public void maxHeapify(int pos) {
			
			if(isLeaf(pos)) return;
			
			if(heap[pos] < heap[getLeft(pos)] ||
					heap[pos] < heap[getRight(pos)]) {
				
				if(heap[getLeft(pos)]>heap[getRight(pos)]) {
					swap(pos,getLeft(pos));
					maxHeapify(getLeft(pos));
				}else {
					swap(pos,getRight(pos));
					maxHeapify(getRight(pos));
				}
				
			}
			
		}
		
		public int extractMax() {
			int removed = heap[0];
			heap[0] = heap[size--];
			maxHeapify(0);
			return removed;
		}
		public void print() {
			 for (int i = 0; i < size / 2; i++) { 
		            System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " + 
		                      heap[(2 * i)+1] + " RIGHT CHILD :" + heap[(2 * i) + 2]); 
		            System.out.println(); 
		     } 
		}
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			max_heap maxHeap = new max_heap(10);
		       maxHeap.insert(5); 
		        maxHeap.insert(3); 
		        maxHeap.insert(17); 
		        maxHeap.insert(10); 
		        maxHeap.insert(84); 
		        maxHeap.insert(19); 
		        maxHeap.insert(6); 
		        maxHeap.insert(22); 
		        maxHeap.insert(9); 
		        maxHeap.print();
			
		        
		        
		        System.out.println("extracting max : "+maxHeap.extractMax());
		        maxHeap.print();

		}

}
