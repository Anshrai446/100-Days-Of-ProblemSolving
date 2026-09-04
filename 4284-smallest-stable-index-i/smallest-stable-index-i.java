class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        int score =0;
        for(int i=0 ; i<nums.length ; i++){
            int min = Integer.MAX_VALUE;
            for(int j=i ; j<nums.length ; j++){
                min = Math.min(min,nums[j]);
            }
            max=Math.max(max,nums[i]);
            score=max-min;
            if(score<k || score ==k) return i;
        }
        return -1;
    }
}