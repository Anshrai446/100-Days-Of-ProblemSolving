class Solution {
    static int solve(int arr[] , int k , int i , int p , int m , Integer [][] dp){
        if(i>=arr.length) return 0;
        int currLen = i-p+1;
         m  = Math.max(m,arr[i]);
        int ans =0;
        if(dp[i][p] != null) return dp[i][p];
        if(currLen == k){
          int c1  = m*currLen + solve(arr,k,i+1,i+1,0,dp);
          ans = Math.max(ans,c1);
        }else{
              int c1  = m*currLen + solve(arr,k,i+1,i+1,0,dp);
              int c2 = solve(arr,k,i+1,p,m,dp);
              ans = Math.max(ans,Math.max(c1,c2));
        }
        return dp[i][p] = ans;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        Integer [][] dp = new Integer[arr.length][arr.length];
        return solve(arr,k,0 , 0 ,0 , dp);
    }
}