package trees;

import java.util.LinkedList;
import java.util.Queue;

public class insertion {

	
	
	static class Node{
		int key;
		Node left,right;
		
		Node(int data)
		{
			key=data;
			left = null; right = null;
		}
		
	}
	
	
	static Node root;
	static Node temp = root;
	
	static void inorder(Node temp)
	{
		if(temp==null)
			return;
		
		inorder(temp.left);
		System.out.print(temp.key+" ");
		inorder(temp.right);
	}
	
	
	static void insert(Node temp,int data)
	{
		
		Queue<Node> q = new LinkedList<>();
		q.add(temp);
		
		while(!q.isEmpty()){
			
			temp = q.peek();
			q.remove();
			
			if(temp.left==null) {
				temp.left=new Node(data);break;
			}else {
				q.add(temp.left);
			}
			if(temp.right==null) {
				temp.right=new Node(data);break;
			}else {
				q.add(temp.right);
			}
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		root = new Node(10); 
        root.left = new Node(11); 
        root.left.left = new Node(7); 
        root.right = new Node(9); 
        root.right.left = new Node(15); 
        root.right.right = new Node(8); 
       
        System.out.println( "Inorder traversal before insertion:"); 
        inorder(root); 
        
        insert(root,12);
        System.out.println( ""); 
        System.out.println( "Inorder traversal before insertion:"); 
        inorder(root); 

	}

}























