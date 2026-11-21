class Solution {
    public boolean isPalindrome(String s) {
        char[] c = s.toLowerCase().toCharArray();
        int i = 0;
        int j = s.length()-1;

        while(i < j) {
            if(!(Character.isDigit(c[i]) || Character.isLetter(c[i]))) {
                i++;
                continue;
            }

            if(!(Character.isDigit(c[j]) || Character.isLetter(c[j]))) {
                j--;
                continue;
            }

            if(c[i] != c[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
