class Solution {
    public String minWindow(String s, String t) {
        if(s.length() <t.length())
            return "";
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();

        for(int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);
        }

        int minCount = Integer.MAX_VALUE;
        int have = 0;
        int need = tMap.size();
        int i = 0;
        int j = 0;
        int start = 0;
        // X=1,Y=1,Z=1 -- have=2 -- need=3 -- minCount = 4
        // O=0,U=0,Z=0,D=0,Y=1,X=1,A=1,Z=1
        while(i < s.length()) {
            windowMap.put(s.charAt(i), windowMap.getOrDefault(s.charAt(i), 0)+1);
            if(tMap.containsKey(s.charAt(i)) && (tMap.get(s.charAt(i)).intValue() == windowMap.get(s.charAt(i)).intValue())) {
                have++;
            }

            while(need == have) {
                if(minCount > (i-j+1)) {
                    minCount = i-j+1;
                    start = j;
                }

                windowMap.put(s.charAt(j), windowMap.get(s.charAt(j)) - 1);
                if(tMap.containsKey(s.charAt(j)) && tMap.get(s.charAt(j)).intValue() > windowMap.get(s.charAt(j)).intValue()) {
                    have--;
                }
                j++;
            }

            if(have != need)
                i++;
        }
        return minCount == Integer.MAX_VALUE ? "" : s.substring(start, start+minCount);
    }
}
