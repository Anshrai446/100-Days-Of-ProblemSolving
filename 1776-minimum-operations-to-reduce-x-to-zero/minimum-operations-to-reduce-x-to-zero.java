class Solution {
    public int minOperations(int[] nums, int x) {

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        int target = sum - x;

        int i = 0;
        int windowSum = 0;
        int maxLength = -1;

        for (int j = 0; j < nums.length; j++) {
            windowSum += nums[j];
            while (windowSum > target && i <= j) {
                windowSum -= nums[i];
                i++;
            }
            if (windowSum == target) {
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        if (maxLength == -1) {
            return -1;
        }
        return nums.length - maxLength;
    }
}