class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<>();

        // Creating the string into character array and sorting them
        // Converting them into string and adding the strings to it.
        for(int i = 0; i < strs.length; i++){
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String arr = Arrays.toString(c);

            if(strMap.containsKey(arr)){
                strMap.get(arr).add(strs[i]);
            }else{
                strMap.put(arr, new ArrayList<>());
                strMap.get(arr).add(strs[i]);
            }
        }
        return new ArrayList<>(strMap.values());
    }
}
