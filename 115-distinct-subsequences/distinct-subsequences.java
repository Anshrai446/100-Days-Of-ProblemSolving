class Solution {
    static int solve(String s , String t , int i , int j , Integer [][] dp){
        if(j==t.length()) return 1;
        if(i==s.length()) return 0;
        if(dp[i][j]!=null) return dp[i][j];

        if(s.charAt(i)==t.charAt(j)){
          int include =  solve(s,t,i+1,j+1,dp);
          int exclude = solve(s,t,i+1,j,dp);
           return dp[i][j] = include+exclude;
        }
        return dp[i][j] = solve(s,t,i+1,j,dp);
    }
    public int numDistinct(String s, String t) {
        Integer [][] dp = new Integer[s.length()][t.length()];
        return solve(s,t,0,0,dp);
    }
}