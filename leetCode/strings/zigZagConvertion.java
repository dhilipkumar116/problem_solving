package strings;

import java.util.HashMap;

public class zigZagConvertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="PAYPALISHIRING";
		int numRows=3;
		
		// 0(N) - complexity and 0(1) - space
		usingMap(numRows,s);
		
		// 0(N) - complexity and 0(N*ROW) - space
		 char[][] dp = new char[numRows][s.length()];
	        int i=0,x=0,y=0;
	        boolean down = true;
	        while(i<s.length()){
	        	//moving down in the 1st column 
	            if(down){
	                dp[y][x] = s.charAt(i);
	                if(y==numRows-1){
	                    down=false;
	                    x++;
	                    y--;
	                }else{
	                    y++;
	                }  
	            }else{//coming back to 0th row diagonally
	                dp[y][x] = s.charAt(i);
	                if(y==0){
	                    down=true;
	                    y++;
	                }else{
	                    x++;
	                    y--;
	                }	                
	            }
	            i++;
	        }
	        String result="";
	        for(int r=0;r<numRows;r++){
	            for(int c=0;c<dp[0].length;c++){
	    	        System.out.print(dp[r][c]);
	                if(dp[r][c]!=0){
	                    result += dp[r][c];
	                }
	            }
		        System.out.println();
	        }
	        
	        System.out.println("-----------------------");
	        System.out.print(result);
	}
	
	static void usingMap(int row, String s){
		
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		
		int currentRow=1;
		int addFactor=1;// factor for moving up or down the row
		for(int j=0;j<s.length();j++) {
			if(map.containsKey(currentRow)) {
				map.put(currentRow,map.get(currentRow)+(String.valueOf(s.charAt(j))));
			}else {
				map.put(currentRow, String.valueOf(s.charAt(j)));
			}
			if(currentRow==row&&addFactor==1) {//   If currentRow value is Max.
				addFactor=-1;                  //   Moving 'DOWN' the Row 
			}
			if(currentRow==1&&addFactor==-1) {//   If currentRow value is Min.
				addFactor=1;                  //   Moving 'UP' the Row
			}
			currentRow += addFactor;//Moving 'UP' or 'DOWN' the Row.
		}
		String result2="";
		for(int j=1;j<=row;j++) {
			if(map.containsKey(j))
				result2 +=map.get(j); 
		}
		System.out.println(result2);
	}

}
