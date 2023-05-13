package practise;
import java.util.*;

public class LinkedList {

	static Node head = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		LinkedList ll = new LinkedList();
		ll.add(5);
		ll.add(1);
		ll.add(3);
		ll.add(6);
		ll.add(7);
		ll.add(2);
		ll.delete(1);
		ll.delete(3);
		ll.delete(7);
		
		
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}

	}
	
	public void delete(int key) {
		if(key == head.value) {
			head = head.next;
			return;
		}
		
		Node temp = head;
		Node prev = null;
		while(temp!=null) {
			if(temp.value == key) {
				if(temp.next == null) {
					//delete at end
					prev.next = null;
					return;
				}else {
					//delete at middle
					prev.next = temp.next;
					return;
				}
			}
			prev = temp;
			temp = temp.next;
		}
		System.out.println("key not found");
	}
	
	public void add(int key) {
		if(head == null) {
			head = new Node(key);
			return;
		}
		
		if(key <= head.value) {
			Node newNode = new Node(key);
			newNode.next = head;
			head = newNode;
			return;
		}
		
		Node temp = head;
		while(temp != null) {
			if(temp.next != null && key < temp.next.value) {
				Node nextNode = temp.next;
				Node newNode = new Node(key);
				temp.next = newNode;
				newNode.next = nextNode;
				break;
			}else if(temp.next == null) {
				Node newNode = new Node(key);
				temp.next = newNode;
				break;
			}
			temp = temp.next;
		}
	}

}


class Node{
	int value;
	Node next;
	Node(){
		
	}
	Node(int value) {
		this.value = value;
	}
}