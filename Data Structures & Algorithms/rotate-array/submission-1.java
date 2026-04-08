class Solution {
    public void rotate(int[] nums, int k) {
        // [1,2,3,4,5,6,7] n = 7

        int[] tempNums = new int[k%nums.length]; // 100 % 7 = 2
        int[] tempNumsFront = new int[nums.length - k%nums.length]; // 7-2 = 5
        int front = 0, back = 0;
        
        for(int i = nums.length - tempNums.length; i < nums.length; i++) { // i < 2
            tempNums[back++] = nums[i]; // [6,7]
            // System.out.println(Arrays.toString(tempNums));
        }


        for(int i = 0; i < nums.length - tempNums.length; i++) { 
            tempNumsFront[front++] = nums[i]; // [1,2,3,4,5]
        }
        
        int cnt = 0;
        for(int i = 0; i < tempNums.length; i++) {
            nums[i] = tempNums[cnt++]; //
        }

        for(int i = 0; i < tempNumsFront.length; i++) {
            nums[cnt++] = tempNumsFront[i];
        }
    }
}