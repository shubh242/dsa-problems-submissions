class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();

        // Putting all the characters in string s
        for(int i = 0; i < s.length(); i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+1);
        }

        // Checking if the character in string t is present in sMap if not returning false
        for(int i = 0; i < t.length(); i++){
            if(!sMap.containsKey(t.charAt(i))){
                return false;
            }else{
                if(sMap.get(t.charAt(i))==1){
                    sMap.remove(t.charAt(i));
                }else{
                    sMap.put(t.charAt(i), sMap.get(t.charAt(i))-1);
                }
            }
        }
        return sMap.size() == 0;
    }
}
