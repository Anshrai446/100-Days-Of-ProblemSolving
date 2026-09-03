class Solution {
    static final int INF = 1000000;
    static int  solve(int amount , int index , int [] coins ,Integer [][] dp){
        if(amount == 0) {
            return 0 ;
        }
        if(amount<0 || index>=coins.length){
            return INF;
        }
        if(dp[index][amount]!=null) return dp[index][amount];
        int include = 1 + solve(amount-coins[index] , index , coins ,dp );
        int exclude = solve(amount , index+1 , coins,dp);
        dp[index][amount] = Math.min(include,exclude);
        return Math.min(include,exclude);
    }
    public int coinChange(int[] coins, int amount) {
        Integer [][] dp = new Integer[coins.length+1][amount+1];
      int ans  = solve(amount , 0 , coins,dp);
      return ans==INF?-1:ans;  
    }
}