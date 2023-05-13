package arrays;

public class waterContainerMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.print(maxArea(height));
	}
	
		
     public static int maxArea(int[] height) {
        
        int i = 0 ;
        int j =  height.length-1;
        int max = 0;
        while(i<j){
            if(height[i]<height[j]){
                max = Math.max(max,Math.min(height[i],height[j])* (j - i++));
            }else{
                max = Math.max(max,Math.min(height[i],height[j])* (j-- - i));
            }
        }
        return max;
     }

}





