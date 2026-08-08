class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sArray = computeOcc(s);
        int[] tArray = computeOcc(t);

        for(int i = 0; i < 26; i++) {
            if(sArray[i] != tArray[i])
                return false;
        }

        return true;
    }

    public int[] computeOcc(String s) {
        int[] arr = new int[26];

        for(int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);

            arr[temp-'a']++;
        }

        return arr;
    }
}
