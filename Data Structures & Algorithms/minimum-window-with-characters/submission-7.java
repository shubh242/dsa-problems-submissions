class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 1 && t.length() == 1){
            if(s.charAt(0) == t.charAt(0))
                return String.valueOf(s.charAt(0));
            return "";
        }

        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);
        }
        int i = 0, j = 0;
        StringBuilder res = new StringBuilder();
        int need = tMap.size(), have = 0, start = 0;
        int minCount = Integer.MAX_VALUE;
        String str = "";

        while(j < s.length()){
            res.append(s.charAt(j));
            windowMap.put(s.charAt(j), windowMap.getOrDefault(s.charAt(j),0)+1);
            
            if(tMap.containsKey(s.charAt(j)) && tMap.get(s.charAt(j)) == windowMap.get(s.charAt(j))){
                have++;
            }

            while(have == need){
                if(minCount > (j-i+1)){
                    minCount = (j-i+1);
                    start = i;
                }

                windowMap.put(s.charAt(i), windowMap.get(s.charAt(i))-1);
                if(tMap.containsKey(s.charAt(i)) && tMap.get(s.charAt(i)) > windowMap.get(s.charAt(i))){
                    have--;
                }
                i++;
            }

            if(have != need){
                j++;
            }
        }
        return minCount == Integer.MAX_VALUE ? "" : s.substring(start, start + minCount);
    }
}
