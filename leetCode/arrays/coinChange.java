package arrays;

public class coinChange {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int amount = 7;
		int[] coins = {2,3};
		int[] dp = new int[amount+1];
		int result = coinChange(amount,coins,dp);
		System.out.println(result);
	}

	
	 private static int coinChange(int amount, int[] coins,int[] dp){
	        if(amount == 0){
	            return 0; 
	        }
	        
	        if(dp[amount] != 0){
	            return dp[amount];
	        }
	        
	        int coinCount = 0;
	        int minCoinCount = Integer.MAX_VALUE;
	        
	        for(int i = 0; i < coins.length; i++){
	            if(amount >= coins[i]){
	                coinCount = coinChange(amount - coins[i], coins,dp);
	                if(coinCount >= 0){
	                    minCoinCount = Math.min(minCoinCount, coinCount);
	                }
	            }
	        }
	        if(minCoinCount == Integer.MAX_VALUE){
	            dp[amount] = -1;
	        }
	        else{
	            dp[amount] = 1 + minCoinCount;
	        }
	        
	        return dp[amount];
	    }
	    
}
