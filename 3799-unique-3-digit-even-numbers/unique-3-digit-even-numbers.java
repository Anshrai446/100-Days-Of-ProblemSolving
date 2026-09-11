class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;
        int [] freq = new int[10];
        for(int digit : digits){
            freq[digit]++;
        }
        int ans =0;
        for(int unit=0 ; unit<=8 ; unit+=2){
            if(freq[unit]==0) continue;
            freq[unit]--;
            for(int hundred = 1 ; hundred<=9 ; hundred++){
                if(freq[hundred]==0) continue;
                freq[hundred]--;
                for(int tens = 0 ; tens<=9 ; tens++){
                    if(freq[tens]>0){
                        ans++;
                    }
                }
                freq[hundred]++;
            }
            freq[unit]++;
        }
        return ans;
    }
}