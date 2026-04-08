class Solution {
    public boolean isValid(String s) {
        List<Character> cList = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                cList.add(s.charAt(i));
            }else{
                if(cList.isEmpty()){
                    return false;
                }
                if(s.charAt(i) == ')' && cList.get(cList.size()-1) == '('){
                    cList.remove(cList.size()-1);
                }else if(s.charAt(i) == '}' && cList.get(cList.size()-1) == '{'){
                    cList.remove(cList.size()-1);
                }else if(s.charAt(i) == ']' && cList.get(cList.size()-1) == '['){
                    cList.remove(cList.size()-1);
                }else{
                    return false;
                }
            }
        }
        return cList.isEmpty();
    }
}
