class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length())
            return false;
            
        Map<Character, Integer> strFreqMap = new HashMap<>();

        strFreqMap = countFreq(strFreqMap, s1);

        Map<Character, Integer> tempFreqMap = new HashMap<>();
        int i = 0, j = 0;
        String tempstr = "";

        while((j-i+1) <= s1.length()){
            tempFreqMap.put(s2.charAt(j), tempFreqMap.getOrDefault(s2.charAt(j),0)+1);
            j++;
        }


        while(j < s2.length()){
            if(tempFreqMap.equals(strFreqMap)){
                return true;
            }else{
                System.out.println(tempFreqMap.toString());
                if(tempFreqMap.get(s2.charAt(i))==1)
                    tempFreqMap.remove(s2.charAt(i));
                else
                    tempFreqMap.put(s2.charAt(i), tempFreqMap.get(s2.charAt(i))-1);
                tempFreqMap.put(s2.charAt(j), tempFreqMap.getOrDefault(s2.charAt(j), 0)+1);
                i++;
                j++;
            }
        }
        return tempFreqMap.equals(strFreqMap);
    }

    public Map<Character, Integer> countFreq(Map<Character, Integer> strFreqMap, String s1){
        strFreqMap.clear();
        for(int i = 0; i < s1.length(); i++){
            if(strFreqMap.containsKey(s1.charAt(i))){
                strFreqMap.put(s1.charAt(i), strFreqMap.get(s1.charAt(i))+1);
            }else{
                strFreqMap.put(s1.charAt(i), 1);
            }
        }
        return strFreqMap;
    }
}
