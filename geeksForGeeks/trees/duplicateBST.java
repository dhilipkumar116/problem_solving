package trees;

public class duplicateBST {
	
	static class Node{
		
		int count, key;
		Node left,right;
		
		   Node(int data){
			   this.key=data;
			   left=right=null;
			   count=1;
		   }
		}
	

	
	static void inorder(Node root){
		
		if(root!=null)
		{
			inorder(root.left);
			System.out.print(root.key + "(" +root.count + ") ");
			inorder(root.right);
		}
		
	}
		
	static Node insert(Node root , int data) {
	
		
		if(root==null) {
			return new Node(data);
		}
		
		if(data==root.key) {
			root.count++;
			return root;
		}
		
		if(data<root.key)
			root.left = insert(root.left,data);
		else
			root.right = insert(root.right, data);
		
		return root;
			
	}
		
	

	static Node minvalue(Node root) {
		
		if(root.left!=null)
			return root.left;
		
		return root;
	}
	
	static Node delete(Node root , int data) {
		
		if(root==null) return root;
		if(data<root.key)
			root.left = delete(root.left,data);
		else if(data>root.key)
			root.right = delete(root.right,data);
		else {
			
			if(root.count>1) {
				root.count--;
				return root;
			}
			

			if(root.left==null) {
				Node temp = root.right;
				root = null;
				return temp;
			}
			else if(root.right==null){
				Node temp = root.left;
				root=null;
				return temp;
			}
			
			Node temp = minvalue(root.right);
			root.key=temp.key;
			root.right = delete(root.right,temp.key);
		}
		
		return root;
		
	}
	


	public static void main(String[] args) {
		
		Node root = null;
		root= insert(root,10);
		root = insert(root , 20);
		root = insert(root, 30);
		root = insert(root, 30);
		inorder(root);
		System.out.println("deleting 30");
		root = delete(root, 30);
		root = delete(root, 30);
		inorder(root);
		

	}

}






