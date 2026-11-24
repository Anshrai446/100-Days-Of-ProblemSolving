class Solution {
    static void bfs(int i , boolean vis[] ,  int[][] adj){
        int n = adj.length;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(!q.isEmpty()){
            int front = q.remove();
            for(int j=0 ; j<n ; j++){
                if(adj[front][j]==1 && vis[j] == false){
                    q.add(j);
                    vis[j]=true;
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean visited[] = new boolean [n];
        for(int i=0 ; i<visited.length ; i++){
            if(!visited[i]){
                bfs(i,visited,isConnected);
                count++;
            }
        }
        return count;
    }
}