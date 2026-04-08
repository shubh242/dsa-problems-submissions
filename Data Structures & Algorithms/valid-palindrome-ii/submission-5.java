class Solution {
    public boolean validPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }

        s = sb.toString();
        int diff = 0, i = 0, j = s.length()-1;


        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++; j--;
                continue;
            } else {
                if(!(checkPalindrome(i+1, j, s) || checkPalindrome(i, j-1, s))) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return true;
    }

    public boolean checkPalindrome(int i, int j, String s) {
        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++; j--;
            } else {
                return false;
            }
        }
        return true;
    }
}