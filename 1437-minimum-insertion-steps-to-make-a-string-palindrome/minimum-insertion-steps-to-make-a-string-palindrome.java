
class Solution {

    int[][] dp;

    public int minInsertions(String s) {
        int n = s.length();

        dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(s, 0, n - 1);
    }
    private int solve(String s, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = solve(s, i + 1, j - 1);
        }
        int insertLeft = solve(s, i, j - 1);
        int insertRight = solve(s, i + 1, j);

        return dp[i][j] = 1 + Math.min(insertLeft, insertRight);
    }
}
