class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;

        HashMap<Character, Integer> s1Map = new HashMap<>();
        HashMap<Character, Integer> s2Map = new HashMap<>();

        for(int i = 0; i < s1.length(); i++) {
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i),0)+1);
            s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i),0)+1);
        }

        int i = 0; int j = s1.length();

        while(j < s2.length()) {
            if(s1Map.equals(s2Map))
                return true;
            else {
                s2Map.put(s2.charAt(i), s2Map.get(s2.charAt(i))-1);
                if(s2Map.get(s2.charAt(i)) == 0) {
                    s2Map.remove(s2.charAt(i));
                }
            }
            s2Map.put(s2.charAt(j), s2Map.getOrDefault(s2.charAt(j), 0)+1);
            i++; j++;
        }
        return s1Map.equals(s2Map);
    }
}
