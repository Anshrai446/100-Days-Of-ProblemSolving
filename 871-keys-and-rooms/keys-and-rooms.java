class Solution {
    static void bfs (int i , boolean[] vis , List<List<Integer>> rooms){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(q.size()>0){
            int front = q.remove();
            for(int ele : rooms.get(front)){
                if(!vis[ele]){
                vis[ele] = true;
                q.add(ele);
                }
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean unlocked[] = new boolean[n];
        unlocked[0] = true;
        bfs(0,unlocked,rooms);
        for(boolean ele : unlocked){
            if(ele==false) return false;
        }
        return true;
    }
}