package trees;

import java.util.*;
import java.util.Queue;
import java.util.Stack;

public class treeTraverse {

	static class Node{
		Node left,right;
		int key;
		Node(int data){
			key=data;
			right=left=null;
		}
	}
	
	static Node insert(int data,Node root) {
		
		if(root==null) {
			return new Node(data);
		}
		if(data<root.key)
			root.left= insert(data,root.left);
		else
			root.right= insert(data,root.right);
		
		return root;
	}
	
	static void Inorder(Node root) {
		
		if(root==null)
			return;
		
	      Inorder(root.left);
	      System.out.print(root.key+" ");
	      Inorder(root.right);
	}
	
	static void Preorder(Node root) {
	      
		if(root==null)
			return;
		
		System.out.print(root.key+" ");
		Preorder(root.left);
		Preorder(root.right);
		
	}
	
	static void Postorder(Node root) {
		
		if(root==null)
			return;
		Postorder(root.left);
		Postorder(root.right);
		System.out.print(root.key+" ");
	}
	
	
	static void InorderWithoutRec(Node root){
		
		Stack<Node> stack = new Stack<Node>();
		List<Integer> list = new ArrayList<Integer>();
		
		while(root != null || stack.size() > 0) {
			while(root!=null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			list.add(root.key);
			root = root.right;
		}
		
		for(int n:list) {
			System.out.print(n+" ");
		}
		
	}
	
	static void PreOrderWithoutRec(Node root)
	{
		Stack<Node> stack =  new Stack<Node>();
		List<Integer> list = new ArrayList<Integer>();
		stack.push(root);
		while(!stack.isEmpty()) {
			root = stack.pop();
			list.add(root.key);
			if(root.right!=null) {
				stack.add(root.right);
			}
			if(root.left!=null) {
				stack.add(root.left);
			}	
		}
		for(int n:list) {
			System.out.print(n+" ");
		}
	}
	
	static void PostOrderWithoutRec(Node root)
	{
		
		
		
	}
	
	static void Levelorder(Node root) {
		
		if(root==null)
			return;
		
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(root);
		q.add(null);
		while(!q.isEmpty())
		{
			Node curr = q.poll();
			//It deletes the element in the container.
			//The method does not throws an exception 
			//when the Queue is empty, it returns null instead.
			if(curr==null)
			{
				if(!q.isEmpty())
				{
					q.add(null);
					System.out.println();
				}
			}
			else
			{
				if(curr.left!=null)
					q.add(curr.left);
				if(curr.right!=null)
					q.add(curr.right);
				System.out.print(curr.key+" ");
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = null;
		root = insert(10, root);
		insert(5, root);
		insert(6, root);
		insert(2, root);
		insert(11, root);
		insert(16, root);
		
		System.out.print("inorder :");
		Inorder(root);
		System.out.println(" ");
		System.out.print("inorder w/o rec :");
		InorderWithoutRec(root);
		System.out.println(" ");
		System.out.print("post order :");
		Postorder(root);
		System.out.println(" ");
		System.out.print("post order w/o rec:");
		PostOrderWithoutRec(root);
		System.out.println(" ");
		System.out.print("pre order :");
		Preorder(root);
		System.out.println(" ");
		System.out.print("pre order w/o rec :");
		PreOrderWithoutRec(root);
		System.out.println(" ");
		System.out.print("level order(bfs) :");
		Levelorder(root);

	}

}
