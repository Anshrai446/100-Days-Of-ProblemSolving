class Solution {
    static boolean isSafeToPlace(int rowIndex , int colIndex, int n ,char[][] board){
        int row = rowIndex;
        int col = colIndex;
        while(col>=0){
            if(board[row][col]=='Q') return false;
            col--;
        }
        row = rowIndex;
        col = colIndex;
        while(row>=0 && col>=0){
            if(board[row][col]=='Q') return false;
            row--;
            col--;
        }
        row = rowIndex;
        col = colIndex;
        while(row<n && col>=0){
            if(board[row][col]=='Q') return false;
            row++;
            col--;
        }
        return true;
    }
    static void solve(int col , int n , char[][] board,List<List<String>> ans){
        if(col>=n){
            List<String> tmp = new ArrayList<>();
            for(int i=0 ; i<n ; i++){
                tmp.add(new String(board[i]));
            }
            ans.add(tmp);
            return;
        }
        for(int row=0 ; row<n ; row++){
            if(isSafeToPlace(row,col,n,board)){
                board[row][col]='Q';
                solve(col+1,n,board,ans);
                board[row][col]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char [][] board = new char[n][n];
        for(int i=0 ; i<n ; i++){
            Arrays.fill(board[i],'.');
        }
        int col=0;
        List<List<String>> ans = new ArrayList<>();
        solve(col,n,board,ans);
        return ans;
    }
}