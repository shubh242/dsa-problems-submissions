class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1){
            return (nums[0] == target) ? 0 : -1;
        }
        return binarySearch(nums.length-1, 0, (nums.length/2), nums, target);
    }

    public int binarySearch(int high, int low, int mid, int[] nums, int target){
        if(nums[mid] == target)
            return mid;
        else if(low >= high)
            return -1;
        // else if(mid+1 == high){
        //     if(nums[mid] == target)
        //         return mid;
        //     else if(nums[mid+1] == target)
        //         return mid+1;
        // }else if(mid-1 == low){
        //     if(nums[mid] == target)
        //         return mid;
        //     else if(nums[mid-1] == target)
        //         return mid-1;
        // }
        
        if(nums[mid] < target){
            System.out.println("GO HIGHER " + high + " " + low + " " + mid);
            return binarySearch(high, mid+1, (high + (mid+1))/2, nums, target);
        }else if(nums[mid] > target){
            System.out.println("GO LOWER " + high + " " + low + " " + mid);
            return binarySearch(mid-1, low, ((mid-1) + low)/2, nums, target);
        }

        return mid;
    }
}
