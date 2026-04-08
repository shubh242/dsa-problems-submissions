class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1)
            return s;
        
        int i = 0, n = s.length();
        int resLen = Integer.MIN_VALUE;
        String maxPalin = "", temp1 = "", temp2 = "";

        
        while(i < n){
            temp1 = checkFromCenter(s, i, i);
            temp2 = checkFromCenter(s, i, i+1);

            System.out.println(temp1 + " " + temp2);
            if(temp1.length() > temp2.length()){
                if(maxPalin.length() < temp1.length())
                    maxPalin = temp1; 
            }
            else
                if(maxPalin.length() < temp2.length() )
                    maxPalin = temp2;

            i++;
        }
        return maxPalin;
    }
    // 0123
    // abbd
    //  ij

    public String checkFromCenter(String s, int i, int j){
        String palin = "";

        while(i >= 0 && j < s.length()){
            if(s.charAt(i) == s.charAt(j)){
                if(i == j){
                    palin = s.charAt(i) + palin;
                }else{
                    palin = s.charAt(i) + palin + s.charAt(j);
                }
                i--;
                j++;
            }else{
                return palin;
            }
        }
        return palin;
    }
}
