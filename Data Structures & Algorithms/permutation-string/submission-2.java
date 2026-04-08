class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> strFreqMap = new HashMap<>();

        strFreqMap = countFreq(strFreqMap, s1);

        Map<Character, Integer> tempFreqMap = strFreqMap;
        int i = 0, j = s1.length()-1;
        String tempstr = "";

        while(j < s2.length()){
            tempstr = s2.substring(i, j+1);
            int counter = 0;
            System.out.println(tempstr);
            for(int k = 0; k < tempstr.length(); k++){
                if(tempFreqMap.containsKey(tempstr.charAt(k))){
                    strFreqMap.put(tempstr.charAt(k), strFreqMap.get(tempstr.charAt(k))-1);
                    if(strFreqMap.get(tempstr.charAt(k)) == 0){
                        strFreqMap.remove(tempstr.charAt(k));
                    }
                    counter++;
                }else{
                    break;
                }
            }
            System.out.println(strFreqMap);
            if(counter == tempstr.length() && strFreqMap.size() == 0)
                return true;
            strFreqMap = countFreq(strFreqMap, s1);
            i++;
            j++;
        }
        return false;
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
