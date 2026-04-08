class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> anagramsMap = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            if(!anagramsMap.containsKey(giveCounts(strs[i]))){
                List<String> strList = new ArrayList<>();
                strList.add(strs[i]);
                anagramsMap.put(giveCounts(strs[i]), strList);
            }else{
                anagramsMap.get(giveCounts(strs[i])).add(strs[i]);
                // anagramsMap.put(giveCounts(strs[i]), anagramsMap.get(giveCounts(strs[i])).add(strs[i]));
            }
        }

        System.out.println(anagramsMap.toString());
        List<List<String>> res = new ArrayList<>(anagramsMap.values());
        
        return res;
    }

    public Map<Character, Integer> giveCounts(String str){
        Map<Character, Integer> charMap = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            if(charMap.containsKey(str.charAt(i)))
                charMap.put(str.charAt(i), charMap.get(str.charAt(i))+1);
            else
                charMap.put(str.charAt(i),1);
        }
        return charMap;
    }
}
