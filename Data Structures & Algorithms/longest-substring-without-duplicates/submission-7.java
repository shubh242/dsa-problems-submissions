class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        char[] c = s.toCharArray();
        int i = 0;
        int j = 0;
        int longest = 0;

        while(j < c.length) {
            if(set.contains(c[j])) {
                while(i < j && set.contains(c[j])) {
                    set.remove(c[i]);
                    i++;
                }
            }
            set.add(c[j]);
            longest = Math.max(longest, (j-i+1));
            j++;
        }
        return longest;
    }
}
