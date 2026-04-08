class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < word1.length(); i++) {
            if(i == word1.length()-1) {
                sb.append(word1.charAt(i));
                while(i < word2.length()) {
                    sb.append(word2.charAt(i));
                    i++;
                }
            } else if(i == word2.length()-1) {
                sb.append(word1.charAt(i) + "" + word2.charAt(i));
                i++;
                while(i < word1.length()) {
                    sb.append(word1.charAt(i));
                    i++;
                }
            } else {
                sb.append(word1.charAt(i) + "" + word2.charAt(i));
            }
        }
        return sb.toString();
    }
}