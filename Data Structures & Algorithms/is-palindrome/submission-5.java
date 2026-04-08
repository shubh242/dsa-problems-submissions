class Solution {
    public boolean isPalindrome(String s) {
        String fin = "";
        s = s.toLowerCase();
        for(int i = 0; i < s.length(); i++){
            if(Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))){
                fin += s.charAt(i);
            }
        }
        
        int i = 0, j = fin.length()-1;
        while(i <= j){
            if(fin.charAt(i) != fin.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
