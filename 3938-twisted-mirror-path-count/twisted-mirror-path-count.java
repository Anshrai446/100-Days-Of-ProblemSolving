class Solution {
    static final int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[][] dp = new long[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (dp[i][j] == 0) continue;

                // Try moving right
                int[] right = move(grid, i, j, 0);

                if (right != null) {
                    int r = right[0];
                    int c = right[1];

                    dp[r][c] = (dp[r][c] + dp[i][j]) % MOD;
                }

                // Try moving down
                int[] down = move(grid, i, j, 1);

                if (down != null) {
                    int r = down[0];
                    int c = down[1];

                    dp[r][c] = (dp[r][c] + dp[i][j]) % MOD;
                }
            }
        }

        return (int) dp[m - 1][n - 1];
    }

    // dir = 0 -> Right
    // dir = 1 -> Down
    private int[] move(int[][] grid, int i, int j, int dir) {

        int m = grid.length;
        int n = grid[0].length;

        int r = i;
        int c = j;

        while (true) {

            // Move in current direction
            if (dir == 0) {
                c++;
            } else {
                r++;
            }

            // Out of bounds
            if (r >= m || c >= n) {
                return null;
            }

            // Destination reached
            if (r == m - 1 && c == n - 1) {
                return new int[]{r, c};
            }

            // Mirror encountered: reflect again
            if (grid[r][c] == 1) {
                dir = 1 - dir;
            } else {
                // Empty cell reached
                return new int[]{r, c};
            }
        }
    }
}