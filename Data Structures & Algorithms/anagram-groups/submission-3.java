class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String key = Arrays.toString(c);
            List<String> t = map.getOrDefault(key, new ArrayList<>());
            t.add(strs[i]);
            map.put(key, t);
        }
        return new ArrayList<>(map.values());
    }
}
