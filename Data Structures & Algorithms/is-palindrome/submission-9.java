class Solution {
    public boolean isPalindrome(String s) {
        char[] c = s.toLowerCase().toCharArray();
        int i = 0;
        int j = s.length()-1;

        while(i < j) {
            if(!((c[i] >= '0' && c[i] <= '9') || (c[i] >= 'a' && c[i] <= 'z'))) {
                i++;
                continue;
            }

            if(!((c[j] >= '0' && c[j] <= '9') || (c[j] >= 'a' && c[j] <= 'z'))) {
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
