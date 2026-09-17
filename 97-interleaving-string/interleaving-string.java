class Solution {
    
    static boolean solve(String s , String t , String u , int i,int j ,int k,Boolean dp[][]){
        if(k>=u.length()){
            return i>=s.length() && j>=t.length();
        }
        if(i>=s.length()){
            while(j<t.length() && k<u.length()){
                if(t.charAt(j)==u.charAt(k)){
                    j++;
                    k++;
                }else{
                return false;
                }
            }
            return j>=t.length() && k>=u.length();
        }
        if(j>=t.length()){
            while(i<s.length() && k<u.length()){
                if(s.charAt(i)==u.charAt(k)){
                    i++;
                    k++;
                }else{
                 return false;
                }
            }
            return i>=s.length() && k>=u.length();
        }
        if(dp[i][j]!=null) return dp[i][j];
        boolean ans =false;
        if(s.charAt(i)==u.charAt(k)){
            boolean a = solve(s,t,u,i+1,j,k+1,dp);
            ans|=a;
        }
        if(t.charAt(j)==u.charAt(k)){
            boolean b = solve(s,t,u,i,j+1,k+1,dp);
            ans|=b;
        }
        return  dp[i][j] = ans ;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()) return false;

        Boolean dp[][] = new Boolean[s1.length()][s2.length()];    
    
       return solve(s1,s2,s3,0,0,0,dp);
    }   
}