package priorityQ;

import java.util.Iterator;
import java.util.PriorityQueue;

public class basic_inBuild_operation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PriorityQueue<String> pq = new PriorityQueue<String>();
		
		pq.add("c");
		pq.add("c++");
		pq.add("java");
		pq.add("javascript");
		pq.add("python");
		
		
		System.out.println("head value usign peek : "+pq.peek());
		
		System.out.println("list of all elements : ");
		Iterator it1 = pq.iterator();
		while(it1.hasNext()) {
			System.out.println(it1.next());
		}
		
		
		//removing top of the element using pool fn 
		pq.poll();
		System.out.println("queue value after pool : ");
		Iterator it2 = pq.iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		
		//remove using remove method
		pq.remove("java");
		System.out.println("queue value after removing java : ");
		Iterator it3 = pq.iterator();
		while(it3.hasNext()) {
			System.out.println(it3.next());
		}
		
		
		
		 boolean b = pq.contains("C"); 
	        System.out.println("Priority queue contains C "
	                           + "or not?: " + b); 
	        
	        
	        //getting objects from the queue using toArray()
	        Object[] arr = pq.toArray();
	        System.out.println("Value in array: "); 
	        for(int i=0; i<arr.length;i++) {
	        	System.out.println("value : "+arr[i]);
	        }
	        
	}

}
