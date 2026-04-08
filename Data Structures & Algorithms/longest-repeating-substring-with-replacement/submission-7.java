class Solution {
    public int characterReplacement(String s, int k) {
        // XYYX -> X(1)
        // if( == 0)
        //     return 0;

        int maxFreq = Integer.MIN_VALUE, repeating = Integer.MIN_VALUE;
        char maxChar = 'A';
        int i = 0, j = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        while(j < s.length()){
            freqMap.put(s.charAt(j), freqMap.getOrDefault(s.charAt(j), 0)+1);
            if(freqMap.get(s.charAt(j)) >= maxFreq){
                maxFreq = freqMap.get(s.charAt(j));
                maxChar = s.charAt(j);
            }
            while((j-i+1)-maxFreq > k){
                freqMap.put(s.charAt(i), freqMap.get(s.charAt(i))-1);
                i++;
            }
            repeating = Math.max(repeating, (j-i+1));
            j++;
        }
        return repeating;
    }
}
