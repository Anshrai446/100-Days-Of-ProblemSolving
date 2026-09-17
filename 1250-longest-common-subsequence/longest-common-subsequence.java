class Solution {
    static Integer [][] dp = new Integer[1001][1002];
    static int solve(String text1 , String text2 , int i , int j){
        if(i>=text1.length() || j>=text2.length()){
            return 0;
        }
        if(dp[i][j]!=null) return dp[i][j];
        int ans =0;
        if(text1.charAt(i)==text2.charAt(j)){
            int c1 = 1 + solve(text1,text2,i+1,j+1);
            ans+=Math.max(c1,ans);
        }else{
            int c1 = solve(text1,text2,i+1,j);
            int c2 = solve(text1,text2,i,j+1);
            ans+=Math.max(c1,c2);
        }
        return dp[i][j]=ans ; 
    }
    public int longestCommonSubsequence(String text1, String text2) {
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1002; j++) {
                dp[i][j] = null;
            }
    }
    return solve(text1,text2,0,0);
}
}