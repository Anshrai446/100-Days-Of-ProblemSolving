class Solution {
    static int solve(String text1 , String text2 , int i , int j,Integer dp[][]){
        if(i>=text1.length() || j>=text2.length()){
            return 0;
        }
        if(dp[i][j]!=null) return dp[i][j];
        int ans =0;
        if(text1.charAt(i)==text2.charAt(j)){
            int c1 = 1 + solve(text1,text2,i+1,j+1,dp);
            ans+=Math.max(c1,ans);
        }else{
            int c1 = solve(text1,text2,i+1,j,dp);
            int c2 = solve(text1,text2,i,j+1,dp);
            ans+=Math.max(c1,c2);
        }
        return dp[i][j]=ans ; 
    }
    public int longestCommonSubsequence(String text1, String text2) {
        Integer [][] dp = new Integer[text1.length()][text2.length()];
        return solve(text1,text2,0,0,dp);
    }
}