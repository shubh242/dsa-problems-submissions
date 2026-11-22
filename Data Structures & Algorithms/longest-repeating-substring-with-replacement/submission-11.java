class Solution {
    public int characterReplacement(String s, int k) {
        char[] c = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        char max_occ = 'A';
        int maxFreq = Integer.MIN_VALUE;
        int j = 0;
        int longest = 0;

        for(int i = 0; i < c.length; i++) {
            map.put(c[i], map.getOrDefault(c[i], 0)+1);
            if(maxFreq <= map.get(c[i])) {
                maxFreq = map.get(c[i]);
                max_occ = c[i];
            }
            while((i-j+1)-maxFreq > k) {
                map.put(c[j], map.get(c[j])-1);
                j++;
            }
            longest = Math.max(longest, (i-j+1));
        }
        return longest;
    }
}
