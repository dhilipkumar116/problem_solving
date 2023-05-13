package trees;

public class continuousTree {
	
	static class node{
		int key;
		node left,right;
		
		node(int data){
			this.key=data;
			left = right = null;
		}
	}
	
	static node insert(node root , int data) {
		
		if(root==null)
			return new node(data);
		
		if(data<root.key)
			root.left = insert(root.left , data);
		else
			root.right = insert(root.right , data);
		
		return root;
	}

	static boolean isContinous(node root)
	{
		if(root==null)
			return false;
		if(root.left==null&&root.right==null)
			return true;
		if(root.left==null)
			return Math.abs(root.key-root.right.key)==1 
			       && isContinous(root.right);
		if(root.right==null)
			return Math.abs(root.key-root.left.key)==1
			       && isContinous(root.left);
		
		return Math.abs(root.key-root.left.key)==1
				&&Math.abs(root.key-root.right.key)==1
				&&isContinous(root.left)
				&&isContinous(root.right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		node root=null;
		root = insert(root,3);
		root = insert(root,2);
		root = insert(root,4);
		root = insert(root,1);
		root = insert(root,3);
		root = insert(root,5);
		if(isContinous(root)) {
			System.out.print("YES");
		}else
			System.out.print("NO");

	}

}
