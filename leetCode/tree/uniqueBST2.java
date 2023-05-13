package tree;
import java.util.*;

public class uniqueBST2 {
	
	public static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	   }
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<TreeNode> res = generateTrees(1,3);
	    System.out.println(res);
		
	}

	 static List<TreeNode> generateTrees(int start, int end){

	        List<TreeNode> result = new ArrayList<>();
	        if(start>end){
	            result.add(null);
	            return result;
	        }
	        
	        for(int i=start;i<=end;i++){
	            List<TreeNode> left = generateTrees(start,i-1);
	            List<TreeNode> right = generateTrees(i+1,end);
	            for(TreeNode L : left){
	                for(TreeNode R : right){
	                    TreeNode root = new TreeNode(i);
	                    root.left = L;
	                    root.right = R;
	                    result.add(root);
	                }
	            }
	        }
	  
	        return result;
	    }
}
