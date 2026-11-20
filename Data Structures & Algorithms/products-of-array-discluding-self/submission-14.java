class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] postfix = new int[n];
        int[] result = new int[n];
        int product = 1;

        for(int i = 0; i < n; i++) {
            prefix[i] = product * nums[i];
            product = prefix[i];
        }

        product = 1;

        for(int i = n-1; i >= 0; i--) {
            if(i == 0) {
                postfix[i] = product;
            } else if(i == n-1) {
                postfix[i] = prefix[i-1];
            } else {
                postfix[i] = product * prefix[i-1];
            }
            product *= nums[i];
        }

        return postfix;
    }
}  
