class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int sum = 0;
        for(int i=0 ; i<n ; i++){
            Set<Integer> st = new HashSet<>();
            for(int j=i ; j<n ; j++){
                st.add(nums.get(j));
                int count = st.size();
                sum += count*count;
            }
        }
        return sum;
    }
}