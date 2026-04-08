class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1+n2;
        int[] merged = new int[n];
        int i = 0, j = 0;
        int counterM = 0, temp1, temp2;

        while((i+j) <= n/2){
            temp1 = (i >= nums1.length) ? Integer.MAX_VALUE : nums1[i];
            temp2 = (j >= nums2.length) ? Integer.MAX_VALUE : nums2[j];
            if(temp1 < temp2){
                merged[(i+j)] = nums1[i];
                i++;
            }else{
                merged[(i+j)] = nums2[j];
                j++;
            }
            System.out.println(i + " " + j);
        }

        return (n%2 == 0) ? (double) (merged[(n/2)-1] + merged[n/2])/2 : merged[n/2];
    }
}
