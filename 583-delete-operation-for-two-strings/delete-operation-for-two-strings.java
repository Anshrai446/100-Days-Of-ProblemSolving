class Solution {

    static int solve(String word1, String word2, int i, int j, Integer[][] dp) {
        if (i == word1.length()) {
            return word2.length() - j;
        }

        if (j == word2.length()) {
            return word1.length() - i;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int ans;
        if (word1.charAt(i) == word2.charAt(j)) {
            ans = solve(word1, word2, i + 1, j + 1, dp);
        } 
        
        else {
            int delete1 = solve(word1, word2, i + 1, j, dp);
            int delete2 = solve(word1, word2, i, j + 1, dp);

            ans = 1 + Math.min(delete1, delete2);
        }
        dp[i][j] = ans;

        return ans;
    }

    public int minDistance(String word1, String word2) {

        Integer[][] dp = new Integer[word1.length()][word2.length()];

        return solve(word1, word2, 0, 0, dp);
    }
}