class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
            
        Set<Character> noDuplicates = new HashSet<>();
        int i = 0, j = 0, longest = Integer.MIN_VALUE;

        while(j < s.length()){
            
            while(noDuplicates.contains(s.charAt(j))){
                noDuplicates.remove(s.charAt(i));
                i++;
            }
            
            longest = Math.max(longest, (j-i+1));
            noDuplicates.add(s.charAt(j));
            j++;
        }
        return longest;
    }
}
