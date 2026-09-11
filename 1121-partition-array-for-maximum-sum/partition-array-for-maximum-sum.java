class Solution {
    //  j
    //  i 

    // [1 , 15 , 7 , 9 , 2 , 5 ,, 10] 
     
    // 
    static int fun(int [] arr , int i , int p , int m,int k , Integer dp[][]){
        if(i>=arr.length) return 0;
         if(dp[i][p]!=null) return dp[i][p];
        int length = i-p+1;
        m = Math.max(m,arr[i]);
        int ans =0 ; 
        if(length==k){
            int part = m*length + fun(arr,i+1,i+1,0,k,dp);
            ans = Math.max(ans,part);
        }else{
            int part = m*length + fun(arr,i+1,i+1,0,k,dp);
            int move =  fun(arr,i+1,p,m,k,dp);
            ans = Math.max(ans,part);
            ans = Math.max(ans,move);
        }
        return dp[i][p] = ans;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        Integer dp[][] = new Integer[arr.length][arr.length];
        return fun(arr,0,0,0,k,dp);
    }
}