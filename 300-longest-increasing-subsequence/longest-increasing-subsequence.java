class Solution {
    static int solve(int nums[] , int i , int prev , Integer[][] dp){
        if(i>=nums.length) return 0;
        if(dp[i][prev+1]!=null) return dp[i][prev+1];
        int skip = solve(nums,i+1,prev,dp);
        int take =0;
        if(prev==-1 || nums[i]>nums[prev]){
            take = 1 + solve(nums,i+1,i,dp);
        }
        return dp[i][prev+1] = Math.max(take,skip);
    }
    public int lengthOfLIS(int[] nums) {
        Integer [][] dp = new Integer[nums.length][nums.length];
        return solve(nums,0,-1,dp);
    }
}