class Solution {
    public boolean isPalindrome(String s) {
        String str = "";

        for(int k = 0; k < s.length(); k++){
            if(Character.isLetter(s.charAt(k)) || Character.isDigit(s.charAt(k))){
                str += Character.toLowerCase(s.charAt(k));
            }
        }

        int i = 0;
        int j = str.length()-1;
        while(i <= j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
