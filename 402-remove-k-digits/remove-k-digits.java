class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder ans = new StringBuilder();
        for(char Char : num.toCharArray()){
            while(k>0 && ans.length()>0 && Char<ans.charAt(ans.length()-1)){
                ans.deleteCharAt(ans.length()-1);
                k--;
            }
            ans.append(Char);
        }
        while(k>0){
            ans.deleteCharAt(ans.length()-1);
            k--;
        }
        int index=0;
        while(index<ans.length() && ans.charAt(index)=='0'){
            index++;
        }
        String res = ans.substring(index);
        return res.isEmpty()?"0":res;
    }
}