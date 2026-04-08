class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int size = m+n-1;
        m = m-1; n = n-1;
        if(m < 0) {
            while(n >= 0) {
                nums1[size--] = nums2[n--];
            }
            System.out.println(Arrays.toString(nums1));
            return;
        } else if(n < 0) {
            return;
        }

        while(m >= 0 && n >= 0) {
            if(nums1[m] >= nums2[n]) {
                nums1[size--] = nums1[m--];
            } else if(nums1[m] < nums2[n]) {
                nums1[size--] = nums2[n--];
            }
        }

        while(n >= 0 && size >= 0) {
            nums1[size--] = nums2[n--];
        }
    }
}