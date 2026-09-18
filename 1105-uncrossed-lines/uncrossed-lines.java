class Solution {
    static int solve(int [] nums1 , int [] nums2,int i, int j,Integer [][] dp){
        if(i>=nums1.length || j>=nums2.length){
            return 0;
        }
        if(dp[i][j]!=null) return dp[i][j];
        int ans=0;
        if(nums1[i]==nums2[j]){
            int a = 1+solve(nums1,nums2,i+1,j+1,dp);
            ans=Math.max(ans,a);
        }else{
            int a = solve(nums1,nums2,i+1,j,dp);
            int b = solve(nums1,nums2,i,j+1,dp);
            ans = Math.max(ans,Math.max(a,b));
        }
        return dp[i][j] = ans ;
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        Integer [][] dp = new Integer[nums1.length][nums2.length];
        return solve(nums1,nums2,0,0,dp);
    }
}