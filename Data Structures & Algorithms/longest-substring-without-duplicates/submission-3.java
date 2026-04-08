class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = Integer.MIN_VALUE;
        int tempLength = 0;
        int i = 0;
        Map<Character, Integer> noDupes = new HashMap<>();

        while(i < s.length()){
            if(noDupes.containsKey(s.charAt(i))){
                maxLength = Math.max(maxLength, tempLength);
                i = noDupes.get(s.charAt(i))+1;
                noDupes.clear();
                tempLength = 1;
                if(i >= s.length())
                    break;
                noDupes.put(s.charAt(i), i);
            }else{
                noDupes.put(s.charAt(i), i);
                tempLength++;
            }
            i++;
            System.out.println(noDupes.toString() + " " + maxLength);
        }
        return Math.max(maxLength, tempLength);
    }
}
