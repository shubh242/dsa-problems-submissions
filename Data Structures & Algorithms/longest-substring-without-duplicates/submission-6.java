class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;

        int longest = Integer.MIN_VALUE;
        Set<Character> elementSet = new HashSet<>();
        int i = 0, j = 0;

        while(j < s.length()){
            while(elementSet.contains(s.charAt(j)) && i <= j){
                elementSet.remove(s.charAt(i));
                i++;
            }
            elementSet.add(s.charAt(j));
            longest = Math.max(longest, (j-i+1));
            j++;
        }
        return longest;
    }
}
