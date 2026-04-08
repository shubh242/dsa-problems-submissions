class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> occMap = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            occMap.put(nums[i], occMap.getOrDefault(nums[i], 0)+1);

            if(occMap.get(nums[i]) > nums.length/3 && !set.contains(nums[i])) {
                set.add(nums[i]);
            }
        }

        return new ArrayList<>(set);
    }
}