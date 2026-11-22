class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        HashMap<Character, Integer> s1Map = new HashMap<>();
        HashMap<Character, Integer> s2Map = new HashMap<>();
        int j = 0;

        for(int i = 0; i < s1.length(); i++) {
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0)+1);
            s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i), 0)+1);
        }

        for(int i = s1.length(); i < s2.length(); i++) {
            System.out.println(s2Map);
            if(s1Map.equals(s2Map)) {
                return true;
            }
            s2Map.put(s2.charAt(j), s2Map.getOrDefault(s2.charAt(j), 0)-1);
            if(s2Map.get(s2.charAt(j)) == 0) {
                s2Map.remove(s2.charAt(j));
            }
            s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i), 0)+1);
            j++;
        }
        return s1Map.equals(s2Map);
    }
}
