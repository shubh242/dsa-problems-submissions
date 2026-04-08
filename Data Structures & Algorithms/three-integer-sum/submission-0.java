class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 3){
            if((nums[0] + nums[1] + nums[2]) != 0)
                return result;
        }
        int n = nums.length;
        int fixed = 0;
        int k = n-1;
        int sum = 0;
        Set<List<Integer>> numSet = new HashSet<>();
        sort(nums, 0, n-1);
        for(int i = 0; i < n-2; i++){
            fixed = nums[i];
            int j = i+1;
            while(j < k){
                sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> res = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                    numSet.add(res);
                    j++;
                    k--;
                }else if(sum < 0){
                    j++;
                }else{
                    k--;
                }
            }
            k = n-1;
        }

        for(List<Integer> temp: numSet){
            result.add(temp);
        }

        return result;
    }

    public void sort(int[] nums, int low, int high){
        if(low < high){
            int partition = quickSort(nums, low, high);

            sort(nums, low, partition-1);
            sort(nums, partition+1, high);
        }
    }

    public int quickSort(int[] nums, int low, int high){
        int pivot = nums[high];
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(nums[j] <= pivot){
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        int temp = nums[i+1];
        nums[i+1] = nums[high];
        nums[high] = temp;

        return i+1;
    }
}
