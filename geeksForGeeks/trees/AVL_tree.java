package trees;
public class AVL_tree {
	
	class Node{
		int val,height;
		Node left,right;
		Node(int val){
			this.val = val;
			this.height = 1;
		}
	}
	
	private int getHeight(Node root) {
		if(root==null) { return 0; }
		return root.height;
	}

	private int getBalance(Node left,Node right) {
		return getHeight(left)-getHeight(right);
	}
	
	private int setHeight(Node root) {
		int left=0,right=0;
		if(root.left!=null) {
			left = root.left.height;
		}
		if(root.right!=null) {
			right = root.right.height;
		}
		return 1+left+right;
	}
	private Node rightRotate(Node root) {
		Node newNode = root.left;
		root.left = newNode.right;
		newNode.right = root;
		root.height = setHeight(root);
		newNode.height = setHeight(newNode);
		return newNode;
	}
	private Node leftRotate(Node root) {
		Node newNode = root.right;
		root.right = newNode.left;
		newNode.left = root;
		root.height = setHeight(root);
		newNode.height = setHeight(newNode);
		return newNode;
	}
	public Node insert(Node root,int val) {
		if(root==null) {
			return new Node(val);
		}else if(val<root.val) {
			root.left = insert(root.left,val);
		}else {
			root.right =  insert(root.right,val);
		}
		int balance = getBalance(root.left,root.right);
		if(balance>1) {
			if(getHeight(root.left.left)>=getHeight(root.left.right)) {
				return rightRotate(root);
			}else {
				root.left = leftRotate(root.left);
				return rightRotate(root);
			}
		}else if(balance<-1){
			if(getHeight(root.right.right)>=getHeight(root.right.left)) {
				return leftRotate(root);
			}else {
				root.right = rightRotate(root.right);
				return leftRotate(root);
			}
		}else {
			root.height = setHeight(root);
		}
		return root;
	}
	
	public void inOrder(Node root) {
		if(root==null) { return; }
		inOrder(root.left);
		System.out.print(root.val+" ");
		inOrder(root.right);
	}
	
	public static void main(String[] args) {

		//avl -> height balancing BST
		AVL_tree avl = new AVL_tree();
		Node root=null;
		root = avl.insert(root,1);
		root = avl.insert(root,2);
		root = avl.insert(root,3);
		root = avl.insert(root,6);
		root = avl.insert(root,5);
		root = avl.insert(root,-2);
		root = avl.insert(root,-5);
		root = avl.insert(root,-8);
		
		avl.inOrder(root);
	}

}
