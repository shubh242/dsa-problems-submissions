class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> countFreqMap = new HashMap<>();
        char maxFreqChar = 'a';
        int maxFreq = 1;
        int i = 0, count = 0, j = 0;

        while(j < s.length()){
            if(countFreqMap.containsKey(s.charAt(j))){
                countFreqMap.put(s.charAt(j), countFreqMap.get(s.charAt(j))+1);
                if(maxFreq < countFreqMap.get(s.charAt(j))){
                    maxFreq = countFreqMap.get(s.charAt(j));
                    maxFreqChar = s.charAt(j);
                }
            }else{
                countFreqMap.put(s.charAt(j), 1);
                maxFreq = Math.max(maxFreq, countFreqMap.get(s.charAt(j)));
            }

            j++;
            if(((j-i) - maxFreq) <= k){
                count = Math.max(count, (j-i));
            }else{
                // j--;
                System.out.println(((j-i) - maxFreq) + " I CHANGES");
                countFreqMap.put(s.charAt(i), countFreqMap.get(s.charAt(i))-1);
                maxFreqChar = maxChar(countFreqMap);
                maxFreq = countFreqMap.get(maxFreqChar);
                i++;
            }
            System.out.println(k + " " + (j-i) + " " + maxFreq + " -> " + count + " " + i + " " + j + " " + maxFreq + " " + maxFreqChar + " " + countFreqMap.toString());
        }
        return count;
    }

    public char maxChar(Map<Character, Integer> maxFreqMap){
        int maximum = Integer.MIN_VALUE;
        char maximumChar = 'a';
        for(Map.Entry<Character, Integer> mapElement : maxFreqMap.entrySet()){
            if(maximum < mapElement.getValue()){
                maximumChar = mapElement.getKey();
                maximum = mapElement.getValue();
            }
        }
        return maximumChar;
    }
}
