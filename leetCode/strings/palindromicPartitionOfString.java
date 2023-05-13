package strings;

public class palindromicPartitionOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "abcbm";
		char[] str = s.toCharArray();
		int[][]dp= new int[s.length()][s.length()];
		
		
		for(int i=1;i<str.length;i++) {
			if(str[i-1]!=str[i]) {
				dp[i-1][i]=1;
			}
		}
		
		//for(k)

	}

}
