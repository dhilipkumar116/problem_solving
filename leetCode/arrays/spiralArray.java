package arrays;

import java.util.*;

public class spiralArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		
		int top = 0,down=nums.length-1,left=0,right=nums.length-1;
		int direction = 0;	// 0 for left-right,1 for top-down,2 for right-left,3 for down-top
		List<Integer> list = new ArrayList<>();
		
		while(top<=down && left<=right) {
			if(direction==0) {
				for(int i=top;i<=right;i++) {
					list.add(nums[top][i]);
				}
				top++;
				direction=1;
			}else if(direction==1) {
				for(int i=top;i<=down;i++) {
					list.add(nums[i][right]);
				}
				right--;
				direction=2;
			}else if(direction==2) {
				for(int i=right;i>=left;i--) {
					list.add(nums[down][i]);
				}
				down--;
				direction=3;
			}else {
				for(int i=down;i>=top;i--) {
					list.add(nums[i][left]);
				}
				left++;
				direction=0;
			}
		}
		
		
		System.out.print(list);

	}

}
