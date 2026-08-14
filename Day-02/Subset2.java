// class Solution {
//     static void  solve (int [] nums , int index, List<List<Integer>> ans , List<Integer> output){
//         if(index>=nums.length){
//             ans.add(new ArrayList<>(output));
//             return;
//         }
//         output.add(nums[index]);
//         solve(nums,index+1,ans,output);
//         output.remove(output.size()-1);
//         solve(nums,index+1,ans,output);
//     }

//     public List<List<Integer>> subsets(int[] nums) {
//          List<List<Integer>> ans = new ArrayList<>();
//          List<Integer> output = new ArrayList<>();
//          solve(nums,0,ans,output);
//          return ans;
//     }
// }
class Subset2.java {
    static void solve(List<Integer> input,List<Integer> output,List<List<Integer>> ans){
        ans.add(new ArrayList<>(output));
        if(input.size()==0){
            return;
        }
        for(int i=0 ; i<input.size() ; i++){
            List<Integer> ip = new ArrayList<>(input);
            List<Integer> op = new ArrayList<>(output);
            op.add(input.get(i));
            ip.subList(0,i+1).clear();
            solve(ip,op,ans);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> ans = new ArrayList<>();
         List<Integer> input = new ArrayList<>();
         List<Integer> output = new ArrayList<>();
        for(int num : nums){
            input.add(num);
         }
         solve(input,output,ans);
         return ans;
    }
}