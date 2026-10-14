class Solution {
    static int solve(int[] cost , int i , Integer [] dp){
        if(i>=cost.length) return 0;
        if(dp[i]!=null) return dp[i];
        int op1 = cost[i] + solve(cost,i+1,dp);
        int op2 = cost[i] + solve(cost,i+2,dp);
        return dp[i] = Math.min(op1,op2);
    }
    public int minCostClimbingStairs(int[] cost) {
        Integer [] dp = new Integer[cost.length+1];
        int case1 = solve(cost,0,dp);
        int case2 = solve(cost,1 , dp);
        return Math.min(case1,case2);
    }
}