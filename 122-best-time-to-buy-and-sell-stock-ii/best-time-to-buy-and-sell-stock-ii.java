class Solution {
    static int solve(int[] nums , int i , int b,Integer dp[][]){
        if(i==nums.length){
            return 0;
        }
        if(dp[i][b]!=null) return dp[i][b];
        int ans =0;
        if(b==1){
            int c1  = -nums[i] + solve(nums,i+1,0,dp);
            int c2  = 0+solve(nums,i+1,1,dp);
            ans = Math.max(c1,c2);
        }else{
            int c1  = nums[i] + solve(nums,i+1,1,dp);
            int c2 = 0+solve(nums,i+1,0,dp);
            ans = Math.max(c1,c2);
        }
        return dp[i][b] = ans ;
    }
    public int maxProfit(int[] prices) {
        Integer dp[][] = new Integer[prices.length][3];
       return solve(prices,0,1,dp);
    }
}
