class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length() == 1)
            return 1;
        Map<Character, Integer> charMap = new HashMap<>();
        int i = 0, j = 0, longest = Integer.MIN_VALUE, maxFreq = Integer.MIN_VALUE, maxChar = 'A';

        while(j < s.length()){
            charMap.put(s.charAt(j), charMap.getOrDefault(s.charAt(j), 0)+1);
            if(maxFreq <= charMap.get(s.charAt(j))){
                maxFreq = charMap.get(s.charAt(j));
                maxChar = s.charAt(j);
            }

            while((j-i+1) - maxFreq > k){
                charMap.put(s.charAt(i), charMap.get(s.charAt(i))-1);
                i++;
            }

            longest = Math.max(longest, (j-i+1));
            j++;
        }

        return longest;
    }
}
