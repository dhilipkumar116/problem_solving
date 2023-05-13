package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class fourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tgt = 0;
		//int nums[] = {-4,-3,-2,-1,0,0,1,2,3,4};
		int nums[] = {1,0,-1,0,-2,2};
		//int nums[] = {-3,-1,0,2,4,5};
		Arrays.sort(nums);
//		Set<List<Integer>> set = new HashSet<>();
//		for(int i=0;i<nums.length-3;i++) {
//			for(int j=i+1;j<nums.length-2;j++) {
//				int l=j+1;
//				int k = nums.length-1;
//				while(l<k) {
//					int sum = nums[i]+nums[j]+nums[l]+nums[k];
//					if(sum==tgt) {
//						set.add(Arrays.asList(nums[i],nums[j],nums[l],nums[k]));	
//						l++;
//						k--;
//					}
//					if(sum<tgt) {
//						l++;
//					}else if(sum>tgt) {
//						k--;
//					}
//					
//				}
//			}
//		}
//		
//		System.out.println(set+"\n");
		
		
		
		List<List<Integer>> mlist = new ArrayList<>();
		
		for(int i=0;i<nums.length-3;i++) {
			if(i>0 && nums[i]==nums[i-1]) continue;
			for(int j=i+1;j<nums.length-2;j++) {
				if(j>i+1 && nums[j]==nums[j-1]) continue;
				
				int left = j+1;
				int right = nums.length-1;
				while(left<right) {
					int sum = nums[i]+nums[j]+nums[left]+nums[right];
					if(sum==tgt) {
						List<Integer> list = new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[left]);
						list.add(nums[right]);
						mlist.add(list);
						left++;right--;
					
					while(nums[left]==nums[left-1]&&left<right) {
						left++;
					}
					while(nums[right]==nums[right+1]&&left<right) {
						right--;
					}
					
					}else if(sum<tgt) {
						left++;
					}else {
						right--;
					}
				}
			}
		}
		
		System.out.println(mlist+"\n");

	}

}
