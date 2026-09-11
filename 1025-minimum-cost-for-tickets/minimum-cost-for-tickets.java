class Solution {
    static int lowerbound(int [] days , int target){
        int left = 0;
        int right = days.length;
        while(left<right){
            int mid = left+(right-left)/2;
            if(days[mid] >= target) right=mid;
            else left=mid+1;
        }
        return left;
    }
    static int solve(int[] days  , int [] costs , int i ,  int dp[]){
        if(i>=days.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int cost1 = costs[0]+solve(days,costs,i+1,dp);
       int next7=lowerbound(days,days[i]+7);
        int cost2 = costs[1]  + solve(days,costs,next7,dp);
        int next30 =  lowerbound(days,days[i]+30);
        int cost3 = costs[2] + solve(days,costs,next30,dp);
        return dp[i] = Math.min(cost1,Math.min(cost2,cost3));
    }
    public int mincostTickets(int[] days, int[] costs) {
       int dp[] = new int[days.length+1];
        java.util.Arrays.fill(dp,-1);
        return solve(days,costs,0,dp);
    }
}