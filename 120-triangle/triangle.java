class Solution {
    static int solve(List<List<Integer>> triangle,int row , int  col,Integer [][] dp){
        if(row>=triangle.size()) return 0;
        if(dp[row][col]!=null){
            return dp[row][col];
        }
        int c1 = triangle.get(row).get(col) + solve(triangle , row+1,col,dp);
        int c2 = triangle.get(row).get(col) + solve(triangle,row+1,col+1,dp);
        dp[row][col]=Math.min(c1,c2);
        return dp[row][col];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int row=0;
        int col=0;
        Integer [][] dp = new Integer[n][n];
        return solve(triangle,row,col,dp);
    }
}