class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n= s.length();
        int i=0;
        int j=0;
        int ones=0;
        String ans ="";
       while(j<n){
          if(s.charAt(j)=='1') ones++;
          while(ones>k && i<=j){
            if(s.charAt(i)=='1') ones--;
            i++;
          }
          if(ones==k){
            while(i<=j && s.charAt(i)=='0') i++;
            String tmp = s.substring(i,j+1);
            if(ans.isEmpty() || tmp.length()<ans.length() || (tmp.length()==ans.length() && tmp.compareTo(ans)<0)){
                ans=tmp;
            }
          }
          j++;
       }
       return ans;
    }
}