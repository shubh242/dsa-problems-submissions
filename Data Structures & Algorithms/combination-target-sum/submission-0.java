class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums, target, 0, 0, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] nums, int target, int i, int sum, List<Integer> arr){
        if(sum == target){
            result.add(new ArrayList<>(arr));
            return;
        }

        if(i >= nums.length || sum > target)
            return;

        arr.add(nums[i]);
        backtrack(nums, target, i, sum+nums[i], arr);
        arr.remove(arr.size()-1);
        backtrack(nums, target, i+1, sum, arr);
    }
}
