class Solution {
    static boolean solve(char [][] grid , int i , int j , int opening , Boolean [][][] dp){
        int m = grid.length;
        int n = grid[0].length;
       
        if(i>=m || j>=n){
            return false;
        }
        

        if(grid[i][j]=='('){
            opening++;
        }else{
            opening--;
        }
        if(opening<0) return false;
        if(i==m-1 && j==n-1){
              return opening ==0;
        }
        if(dp[i][j][opening]!=null) return dp[i][j][opening];
         boolean down  = solve(grid,i+1,j,opening,dp);
         boolean right = solve(grid,i,j+1,opening,dp);
        return dp[i][j][opening] = down || right;
    }
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Boolean [][][] dp= new Boolean[m][n][m+n];
        return solve(grid,0,0,0 , dp);
    }
}