class Solution {

    static boolean solve(String s, int i, int balance , Boolean [][] dp) {
        if (balance < 0) {
            return false;
        }
        if (i == s.length()) {
            return balance == 0;
        }
        if(dp[i][balance]!=null) return dp[i][balance];
        char ch = s.charAt(i);

        if (ch == '(') {
            return dp[i][balance] = solve(s, i + 1, balance + 1,dp);
        }

        if (ch == ')') {
            return dp[i][balance] = solve(s, i + 1, balance - 1 , dp);
        }
        return dp[i][balance] = solve(s, i + 1, balance + 1 , dp) ||   // '*' = '('
                solve(s, i + 1, balance - 1 , dp) ||   // '*' = ')'
                solve(s, i + 1, balance  , dp);         // '*' = empty
    }

    public boolean checkValidString(String s) {
        Boolean [][] dp = new Boolean[s.length()][s.length()];
        return solve(s, 0, 0 , dp );
    }
}