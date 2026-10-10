class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        
        long k = (long) k1 + k2;

        int n = nums1.length;
        int[] diff = new int[n];
        long total = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            total += diff[i];
            max = Math.max(max, diff[i]);
        }

       
        if (total <= k) return 0;

       
        long[] cnt = new long[max + 1];
        for (int d : diff) cnt[d]++;

               for (int v = max; v > 0 && k > 0; v--) {
            if (cnt[v] == 0) continue;

            long move = Math.min(k, cnt[v]); 
            cnt[v] -= move;
            cnt[v - 1] += move;
            k -= move;
        }

        long ans = 0;
        for (int v = 1; v <= max; v++) {
            ans += cnt[v] * (long) v * v;
        }
        return ans;
    }
}