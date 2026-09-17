class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int i=0;
        int j=arr.length-1;
        int peak = arr[i];
        while(i<=j){
            int mid = i+(j-i)/2;
            if(arr[mid]>=arr[mid+1]){

                peak=mid;
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return peak;
    }
}