class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1)
            return s;
        int i = 0, j = 0;
        int resLen = Integer.MIN_VALUE;
        String maxPalindrome = "a";

        while(i + resLen <= s.length()){
            String temp = s.substring(i,j);
            if(palindrome(temp)){
                if(resLen < (j-i+1)){
                    resLen = (j-i+1);
                    maxPalindrome = temp;
                }
            }

            j++;

            if(j > s.length()){
                i++;
                j = i+1;
            }
        }
        return maxPalindrome;
    }

    public boolean palindrome(String s){
        int i = 0, j = s.length()-1;

        while(i <= j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            
            i++;
            j--;
        }
        return true;
    }
}
