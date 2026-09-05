class Solution {

    static int solve(List<Integer> ip, int index, Map<Integer, Integer> map, Integer[] dp) {

        if (index >= ip.size()) {
            return 0;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        int current = ip.get(index);

        int nextIndex = index + 1;

        if (nextIndex < ip.size() &&
            ip.get(nextIndex) == current + 1) {

            nextIndex++;
        }

        
        int include = current * map.get(current) + solve(ip, nextIndex, map, dp);

        
        int exclude = solve(ip, index + 1, map, dp);

        return dp[index] = Math.max(include, exclude);
    }

    public int deleteAndEarn(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> ip = new ArrayList<>(map.keySet());
        Collections.sort(ip);

        Integer[] dp = new Integer[ip.size()];

        return solve(ip, 0, map, dp);
    }
}