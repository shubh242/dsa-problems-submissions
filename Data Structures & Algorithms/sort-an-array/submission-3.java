class Solution {

    public int partition(int low, int high, int[] nums) {
        int i = low - 1;
        int pivot = nums[high];

        for(int j = low; j < high; j++) {
            if(nums[j] < pivot) {
                i++;
                swap(i, j, nums);
            }
        }

        swap(i + 1, high, nums);
        return i + 1;
    }

    public void swap(int i, int j, int[] nums) {
        // System.out.println("i = " + i + ", j = " + j);
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] quicksort(int low, int high, int[] nums) {

        if(low < high) {
            int pi = partition(low, high, nums);

            quicksort(low, pi-1, nums);
            quicksort(pi+1, high, nums);

            return nums;
        }
        return nums;
    }

    public int[] sortArray(int[] nums) {
        return quicksort(0, nums.length-1, nums);
    }
}