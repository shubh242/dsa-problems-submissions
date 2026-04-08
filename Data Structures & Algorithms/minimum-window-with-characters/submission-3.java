class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 1 && t.length() == 1){
            if(s.charAt(0) == t.charAt(0))
                return String.valueOf(s.charAt(0));
            return "";
        }

        String minString = "";
        String tempString = "";
        int minChar = Integer.MAX_VALUE;
        Map<Character, Integer> tMap = new HashMap<>();
        
        tMap = copyMap(tMap, t);

        for(int i = 0; i <= s.length() - t.length(); i++){
            for(int j = t.length()+i; j <= s.length(); j++){
                // System.out.println(s.length() + " " + j);
                tempString = s.substring(i, j);
                if(checksubstring(tMap, tempString)){
                    if(minChar > (j-i)){
                        System.out.println(tempString + " " + tMap.toString());
                        minString = tempString;
                        minChar = (j-i);
                    }
                }
                tMap.clear();
                tMap = copyMap(tMap, t);
            }
        }
        return minString;
    }

    public boolean checksubstring(Map<Character, Integer> tMap, String str){
        int len = str.length();
        int mapSize = tMap.size();
        int count = 0;
        for(int i = 0; i < len; i++){
            if(tMap.containsKey(str.charAt(i))){
                tMap.put(str.charAt(i), tMap.get(str.charAt(i))-1);
                if(tMap.get(str.charAt(i)) == 0){
                    tMap.remove(str.charAt(i));
                }
                count++;
            }
            if(tMap.size() == 0)
                return true;
        }
        // System.out.println(count + " " + tMap.toString());
        // return (count >= mapSize || count == len) ? true : false;
        return tMap.isEmpty();
    }

    public Map<Character, Integer> copyMap(Map<Character, Integer> tMap, String t){
        for(int i = 0; i < t.length(); i++){
            if(tMap.containsKey(t.charAt(i))){
                tMap.put(t.charAt(i), tMap.get(t.charAt(i))+1);
            }else{
                tMap.put(t.charAt(i), 1);
            }
        }
        return tMap;
    }
}
