class Solution {
    static int solve(int [] nums , int i,Integer[] dp){
        // 1st comdition
        if(i==nums.length) return 1;
        if(dp[i]!=null) return dp[i];
        boolean f1 =false;
        boolean f2 =false;
        boolean f3=false;
        if(i<nums.length-1 && nums[i]==nums[i+1]){
            f1 = solve(nums,i+2,dp)==1;
        }
        if(i<nums.length-2 && nums[i]==nums[i+1] && nums[i]==nums[i+2]){
            f2 = solve(nums,i+3,dp)==1;
        }
        if(i<nums.length-2 && nums[i+1]-nums[i]==1 && nums[i+2]-nums[i+1]==1){
            f3 = solve(nums,i+3,dp)==1;
        }
        if(f1||f2||f3) return dp[i]=1;
        return dp[i] = 0;
    }
    public boolean validPartition(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        int ans = solve(nums,0,dp);
        return ans==1?true:false;
    }
}