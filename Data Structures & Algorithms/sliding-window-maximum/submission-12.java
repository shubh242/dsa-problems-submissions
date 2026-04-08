class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 1 || k == 1)
            return nums;
        // else if(k == 2){
        //     int maxi = Integer.MIN_VALUE;
        //     for(int i = 0; i < nums.length; i++){
        //         maxi = Math.max(maxi, nums[i]);
        //     }
        // }

        int res = nums[0];
        int i = 1, j = k;
        int count = 0;
        List<Integer> maxValue = new ArrayList<>();
        int maxValueIndex = 0;

        for(int l = 0; l < k; l++){
            if(res <= nums[l]){
                res = nums[l];
                maxValueIndex = l;
            }
        }

        maxValue.add(res);

        count++;

        while(j < nums.length){
            
            if(maxValueIndex + k <= j){
                int idx = i;
                res = nums[idx];
                while(idx <= j){
                    if(res < nums[idx]){
                        res = nums[idx];
                        maxValueIndex = idx;
                    }
                    idx++;
                }
            }else{
                if(res <= nums[j]){
                    res = nums[j];
                    maxValueIndex = j;
                }
            }
            
            maxValue.add(res);
            count++;
            if((i+j) >= k){
                i++;
            }
            j++;
        }
        
        int[] result = new int[maxValue.size()];
        for(int val = 0; val < result.length; val++){
            result[val] = maxValue.get(val);
        }

        return result;
    }
}