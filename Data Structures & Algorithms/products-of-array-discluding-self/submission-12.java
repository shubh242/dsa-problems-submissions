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
            postfix[i] = product * nums[i];
            product = postfix[i];
        }
        
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                result[i] = postfix[i+1];
            } else if(i == n-1) {
                result[i] = prefix[i-1];
            } else {
                result[i] = prefix[i-1] * postfix[i+1];
            }
        }

        return result;
    }
}  
