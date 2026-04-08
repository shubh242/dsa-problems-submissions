class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for(int k = 0; k < s.length(); k++){
            if(Character.isLetter(s.charAt(k)) || Character.isDigit(s.charAt(k))){
                sb.append(Character.toLowerCase(s.charAt(k)));
            }
        }

        int i = 0;
        int j = sb.length()-1;
        while(i <= j){
            if(sb.charAt(i) != sb.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
