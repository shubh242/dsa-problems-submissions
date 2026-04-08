class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Adding the s1 number of elements in the list and checking the hashmap
        // if map is equal to s1 return true

        if(s1.length() > s2.length()){
            return false;
        }

        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();

        // a=1,b=1  l=1,c=1
        for(int i = 0; i < s1.length(); i++){
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0)+1);
            s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i), 0)+1);
        }

        int i = 0, j = s1.length();
        
        while(j < s2.length()){
            if(s1Map.equals(s2Map))
                return true;
            else{
                if(s2Map.get(s2.charAt(i)) == 1){
                    s2Map.remove(s2.charAt(i));
                }else{
                    s2Map.put(s2.charAt(i), s2Map.get(s2.charAt(i))-1);
                }
                s2Map.put(s2.charAt(j), s2Map.getOrDefault(s2.charAt(j), 0)+1);
            }
            i++;
            j++;
        }

        return s1Map.equals(s2Map);
    }
}
