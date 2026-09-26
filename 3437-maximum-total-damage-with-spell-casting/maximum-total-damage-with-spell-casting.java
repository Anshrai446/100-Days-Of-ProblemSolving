class Solution {
    static long solve(List<Integer> ip , int i , Map<Integer,Integer> map, Long [] dp){
        if(i>=ip.size()){
            return 0;
        }
        if(dp[i]!=null) return dp[i];
        int next =i+1;
        // if(next<ip.size() && (ip.get(next) == ip.get(i)+1 || ip.get(next) == ip.get(i)+2)){
        //     next++;
        // }
        while (next < ip.size() && ip.get(next) <= ip.get(i) + 2) {
             next++;
         }
        
        long c1  = (long) ip.get(i)*map.get(ip.get(i)) + solve(ip,next,map,dp);
        long c2  = solve(ip,i+1,map,dp);
        return dp[i] = Math.max(c1,c2);
    }
    public long maximumTotalDamage(int[] power) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : power){
            map.put(num , map.getOrDefault(num, 0 )+1);
        }
        List<Integer> ip = new ArrayList<>(map.keySet());
        Collections.sort(ip);
        Long [] dp = new Long[ip.size()];
        return solve(ip,0,map,dp); 
    }
}