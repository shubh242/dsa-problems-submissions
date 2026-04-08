class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        int counter = 0;

        for(int i = 0; i < 3; i++) {
            while(map.containsKey(i)) {
                nums[counter++] = i;
                map.put(i, map.get(i)-1);
                if(map.get(i) == 0) {
                    map.remove(i);
                }
            }
        }
    }
}