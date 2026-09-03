class Solution {
    static int solve(int amount , int index , int[] coins , Integer[][] dp){
        if(amount==0){
            return 1;
        }
        if(amount<0){
            return 0;
        }
        if(index>=coins.length){
            return 0;
        }
        if(dp[index][amount]!=null) return dp[index][amount];
        int include = solve(amount-coins[index] , index , coins,dp);
        int exclude = solve(amount , index+1 , coins,dp);
        dp[index][amount] = include + exclude;
        return include + exclude;
    }
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length][amount+1];
        int ans = solve(amount,0,coins,dp);
        return ans;
    }
}