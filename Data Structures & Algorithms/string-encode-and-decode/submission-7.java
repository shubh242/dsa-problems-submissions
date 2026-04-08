class Solution {
    public int k = 5;
    public String noString = "SPACE_EMPTY_STRING";
    public String encode(List<String> strs) {
        if(strs.isEmpty()){
            return "";
        }
        if(!strs.isEmpty() && strs.size()==1 && strs.get(0).length()==0){
            System.out.println(noString);
            return noString;
        }
        String res = "";
        for(String s: strs){
            for(int i = 0; i < s.length(); i++){
                res += (char) ((int) s.charAt(i) + k);
            }
            res += " ";
        }
        System.out.println(res);
        return res;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        if(str.equals(""))
            return res;
        if(str.equals(noString)){
            res.add("");
            return res;
        }

        String[] temp = str.split(" ");
        for(String s: temp){
            String tempStr = "";
            for(int i = 0; i < s.length(); i++){
                tempStr += (char) ((int)(s.charAt(i)) - k);
            }
            res.add(tempStr);
        }
        return res;
    }
}
