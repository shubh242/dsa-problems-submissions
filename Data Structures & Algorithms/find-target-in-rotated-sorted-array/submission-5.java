class Solution {
    public int search(int[] nums, int target) {
        
        // if(nums.length == 2){
        //     if(nums[0] == target)
        //         return 0;
        //     else if(nums[1] == target)
        //         return 1;
        //     else
        //         return -1;
        // }
        int low = 0;
        int high = nums.length-1;
        int mid = nums.length/2;

        while(low <= high){
            if(nums[mid] == target){
                return mid;
            }

            if(nums[low] <= nums[mid]){
                if(target > nums[mid] || target < nums[low]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }else{
                if(target < nums[mid] || target > nums[high]){
                    high = mid - 1;
                }else{
                    low = mid+1;
                }
            }
            mid = (high+low)/2;
            System.out.println(low + " " + mid + " " + high);
        }

        return -1;
    }

    public int binarySearch(int high, int low, int[] nums, int target){
        if(nums[((high+low)/2)] == target)
            return ((high+low)/2);
        else if(low >= high)
            return -1;
        
        if(nums[((high+low)/2)] < target){
            low = ((high+low)/2)+1;
            return binarySearch(high, low, nums, target);
        }else{
            high = ((high+low)/2)-1;
            return binarySearch(high, low, nums, target);
        }
    }
}
