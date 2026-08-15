class HouseRobber {
    static int solve(int [] nums , int start , int end){
        if(start>end){
            return 0;
        }
        int include = nums[start] + solve(nums,start +2 , end);
        int exclude = 0 + solve(nums , start+1 , end);
        return Math.max(include,exclude);
    }
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int case1 = solve(nums,1,nums.length-1);
        int case2 = solve(nums,0,nums.length-2);
        return Math.max(case1,case2);
    }
}