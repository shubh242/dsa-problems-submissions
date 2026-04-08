class Solution {
    public boolean isPalindrome(String s) {
        String str = "";

        for(int k = 0; k < s.length(); k++){
            System.out.println((!((int) s.charAt(k) < 65 || (int) s.charAt(k) > 125)) + " || " + ((int) s.charAt(k) >= 0 && (int) s.charAt(k) <= 9));
            if(Character.isLetter(s.charAt(k)) || Character.isDigit(s.charAt(k))){
                str += Character.toLowerCase(s.charAt(k));
            }
        }

        System.out.println(str);
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
