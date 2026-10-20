import java.util.*;

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;

            boolean valid = true;

            for (int start = 0; start < n && valid; start += k) {
                if (!isRotation(nums, sorted, start, k)) {
                    valid = false;
                }
            }

            if (valid) ans += k;
        }

        return ans;
    }

    private boolean isRotation(int[] nums, int[] sorted,
                               int start, int k) {
       
        int[] pattern = new int[k];
        int[] doubled = new int[2 * k - 1];

        for (int i = 0; i < k; i++) {
            pattern[i] = sorted[start + i];
            doubled[i] = nums[start + i];
        }

        for (int i = 0; i < k - 1; i++) {
            doubled[k + i] = nums[start + i];
        }

        int[] lps = buildLPS(pattern);

        int i = 0, j = 0;

        while (i < doubled.length) {
            if (doubled[i] == pattern[j]) {
                i++;
                j++;

                if (j == k) return true;
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }

        return false;
    }
    private int[] buildLPS(int[] pattern) {
        int[] lps = new int[pattern.length];
        int len = 0;
        for (int i = 1; i < pattern.length; ) {
            if (pattern[i] == pattern[len]) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }

        return lps;
    }
}