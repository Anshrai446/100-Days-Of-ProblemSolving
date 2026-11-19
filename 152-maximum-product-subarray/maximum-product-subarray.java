class Solution {
    public int maxProduct(int[] nums) {
        // [2 , 3 , -2 , 4]
                       //i
        // mE=-2
        //miE=-12
        //res=-2
      int n = nums.length;
      if(n==1) return nums[0];
      int maxEnding = nums[0];
      int minEnding = nums[0];
      int max = nums[0];
      for(int i=1 ; i<n ; i++){
        int opt1 = nums[i];
        int opt2 = maxEnding*nums[i];
        int opt3 = minEnding*nums[i];
        minEnding = Math.min(Math.min(opt1,opt2),opt3);
        maxEnding = Math.max(Math.max(opt1,opt2),opt3);
        max = Math.max(max,Math.max(minEnding,maxEnding));
      }
      return max;
    }
}