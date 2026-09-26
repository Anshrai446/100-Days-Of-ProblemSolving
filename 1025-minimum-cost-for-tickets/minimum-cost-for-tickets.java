class Solution {
    static int lowerBound (int days [] , int target){
        int i=0;
        int j = days.length;
        while(i<j){
            int mid = i+(j-i) / 2;
            if(days[mid]>=target) j = mid;
            else i = mid+1;
        }
        return i;
    }
    static int  solve( int [] days , int [] cost , int i , Integer [] dp){
        if(i>=days.length){
            return 0;
        }
        if(dp[i]!=null) return dp[i];
        int cost1 = cost[0]  + solve(days , cost , i+1 , dp);
        int next7 = lowerBound(days,days[i]+7);
        int cost7 = cost[1] + solve(days,cost,next7 , dp);
        int next30 = lowerBound(days,days[i]+30);
        int cost30 = cost[2] + solve(days,cost,next30 , dp);
        return dp[i] = Math.min(cost1,Math.min(cost7,cost30));
    }
    public int mincostTickets(int[] days, int[] costs) {
        Integer [] dp = new Integer[days.length+1];
        return solve(days , costs , 0 , dp);
    }
}