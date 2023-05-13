package trees;

class Node
{
	int key;
	Node left,right;
	
	Node(int key)
	{
		this.key=key;
		left=right=null;
	}
}

public class basic_tree {
	
	static Node root;
	
	basic_tree(int key)
	{
		root=new Node(key);
	}
	
	basic_tree()
	{
		root=null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		basic_tree bs= new basic_tree();
		bs.root= new Node(1);
		bs.root.left=new Node(2);
		bs.root.right=new Node(3);
		bs.root.left.right= new Node(4);
		bs.root.right= new Node(5);
		bs.root.right.left= new Node(6);
		bs.root.right.right = new Node(7);
		int res = count(root);
	}
	public static int count(Node root) {
		if(root==null) {
			return 0;
		}
		return 1+count(root.left)+count(root.right);
	}

}


