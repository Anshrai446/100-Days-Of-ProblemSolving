class Solution {
    static int solve(String s , int i , int b){
        if(i==s.length()){
            return b;
        }
        char ch = s.charAt(i);
        if(ch=='('){
            return solve(s,i+1,b+1);
        }
         if(b>0){
           return solve(s,i+1,b-1);
        }
        return 1 + solve(s,i+1,b);
    }
    public int minAddToMakeValid(String s) {
       return solve(s,0,0);
    }
}