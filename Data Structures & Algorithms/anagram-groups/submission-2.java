class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> occMap = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            int[] temp = new int[26];
            for(int j = 0; j < strs[i].length(); j++) {
                temp[strs[i].charAt(j)-'a']++;
            }

            String key = Arrays.toString(temp);
            ArrayList<String> arr = occMap.getOrDefault(key, new ArrayList<>());
            arr.add(strs[i]);
            occMap.put(key, arr);
        }

        return new ArrayList<>(occMap.values());
    }
}
