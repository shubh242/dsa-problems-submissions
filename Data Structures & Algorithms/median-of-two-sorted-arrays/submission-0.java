class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] merged = new int[n];
        int i = 0, j = 0;
        int counterM = 0, temp1, temp2;

        while(counterM < n){
            temp1 = (i >= nums1.length) ? Integer.MAX_VALUE : nums1[i];
            temp2 = (j >= nums2.length) ? Integer.MAX_VALUE : nums2[j];
            if(temp1 < temp2){
                merged[counterM] = nums1[i];
                i++;
            }else{
                merged[counterM] = nums2[j];
                j++;
            }
            counterM++;
        }

        return (n%2 == 0) ? (double) (merged[(n/2)-1] + merged[n/2])/2 : merged[n/2];
    }
}
