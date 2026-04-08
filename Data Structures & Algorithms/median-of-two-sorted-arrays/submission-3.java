class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = (n1+n2)/2 + 1;
        int[] merged = new int[n];
        int i = 0, j = 0;
        int temp1 = 0, temp2 = 0;

        while((i+j) < n){
            temp1 = (i >= n1) ? Integer.MAX_VALUE : nums1[i];
            temp2 = (j >= n2) ? Integer.MAX_VALUE : nums2[j];
            if(temp1 < temp2){
                merged[(i+j)] = nums1[i];
                i++;
            }else{
                merged[(i+j)] = nums2[j];
                j++;
            }
        }

        return ((n1+n2)%2 == 0) ? (double) (merged[n-1] + merged[n-2])/2 : merged[n-1];
    }
}
