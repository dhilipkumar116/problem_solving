package trees;

public class findNthNode {

	static int count=0;
	static int flag=0;
    static int pole =0;
	static class Node {
		int key;
		Node left,right;
		
		Node(int data){
			key=data;
			left=right=null;
		}
	}
	
	static void IN_Nthnode(Node root,int n) {
		
		if(root==null)
			return;
		
		if(count<=n)
		{
			IN_Nthnode(root.left,n);
			count++;
			
			if(count==n)
				System.out.println(root.key);
			IN_Nthnode(root.right,n);
		}
	}
	
	static void POST_Nthnode(Node root, int n) {
		
		if(root==null)
			return;
		if(flag<=n) {
			
			POST_Nthnode(root.left,n);
			POST_Nthnode(root.right,n);
			flag++;
			
			if(flag==n)
				System.out.println(root.key);
		}
	}
	
	static void PRE_Nthnode(Node root , int n) {
		
		if(root==null)
			return;
		
		if(pole<=n)
		{
			pole++;
			if(pole==n)
				System.out.println(root.key);
			
			PRE_Nthnode(root.left,n);
			PRE_Nthnode(root.right,n);
		}
	}
	public static void main(String[] args) {
		
		Node root = null;
		root=new Node(10);
		root.left=new Node(20);
		root.right = new Node(15);
		root.left.left=new Node(22);
		root.left.right = new Node(11);
		IN_Nthnode(root,3);
		System.out.println(" ");
		POST_Nthnode(root,3);
		System.out.println(" ");
		PRE_Nthnode(root,3);
	}

}
