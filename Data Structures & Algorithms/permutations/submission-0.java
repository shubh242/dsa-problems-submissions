class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            HashSet<Integer> s = new HashSet<>();
            ArrayList<Integer> l = new ArrayList<>();
            l.add(nums[i]);
            s.add(nums[i]);
            backtrack(nums, result, s, l);
        }
        return result;
    }

    public void backtrack(int[] nums, List<List<Integer>> result, HashSet<Integer> set, ArrayList<Integer> tmp) {
        if(tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i]))
                continue;
            tmp.add(nums[i]);
            set.add(nums[i]);
            backtrack(nums, result, set, tmp);
            tmp.remove(tmp.size()-1);
            set.remove(nums[i]);
        }
    }
}
