class Solution {
    static int solve(String s1 , String s2 , int i , int j , Integer [] [] dp){
        if(i==s1.length()){
            int sum = 0;
            while(j<s2.length()){
                sum+=s2.charAt(j);
                j++;
            }
            return sum;
        }
        if(j==s2.length()){
            int sum=0;
            while(i<s1.length()){
                sum+=s1.charAt(i);
                i++;
            }
            return sum;
        }
        if(dp[i][j]!=null) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        if(s1.charAt(i) == s2.charAt(j)){
            int c1 = solve(s1,s2,i+1,j+1,dp);
            ans = Math.min(ans,c1);
        }
        int deleteC1 = s1.charAt(i)  + solve(s1,s2,i+1,j,dp);
        int deleteC2 = s2.charAt(j) + solve(s1,s2,i,j+1,dp);

        ans = Math.min(ans,Math.min(deleteC1 , deleteC2));
        return dp[i][j] = ans;
    }
    public int minimumDeleteSum(String s1, String s2) {
        Integer [] [] dp = new Integer[s1.length()][s2.length()];
        return solve(s1,s2,0,0,dp);
    }
}