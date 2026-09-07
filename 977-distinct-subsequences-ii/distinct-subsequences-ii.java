class Solution {
    // static void solve(String s ,int index , StringBuilder op,Set<String> set){
    //     if(index>=s.length()){
    //         if(op.length()>0) set.add(op.toString());
    //         return;
    //     } 

    //     op.append(s.charAt(index));
    //     solve(s,index+1,op,set);
    //     op.deleteCharAt(op.length()-1);
    //     solve(s,index+1,op,set);
    // }
    public int distinctSubseqII(String s) {
        // StringBuilder op = new StringBuilder();
        // Set<String> set = new HashSet<>();
        // solve(s,0,op,set);
        // return set.size();
        int MOD = 1000000007;
        int n = s.length();
       int  dp[] = new int[n+1];
       dp[0]=1;
       int last [] = new int[26];
       for(int i=0 ; i<26 ; i++){
           last[i]=-1;
       }
       for(int i=1 ; i<=n ; i++){
            int ch = s.charAt(i-1)-'a';
            dp[i] = (2*dp[i-1])%MOD;
            if(last[ch]!=-1){
                dp[i] = (dp[i] - dp[last[ch]-1]+MOD)%MOD;
            }
            last[ch]=i;
       }
       return (dp[n]-1+MOD)%MOD;
    }
}