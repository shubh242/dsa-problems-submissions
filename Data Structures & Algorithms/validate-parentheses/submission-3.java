class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int stackCounter = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack[stackCounter] = s.charAt(i);
                stackCounter++;
            }else{
                if(stackCounter > 0){
                    if(s.charAt(i) == ')' && stack[stackCounter-1] == '('){
                        stack[stackCounter-1] = 'e';
                        stackCounter--;
                    }else if(s.charAt(i) == ']' && stack[stackCounter-1] == '['){
                        stack[stackCounter-1] = 'e';
                        stackCounter--;
                    }else if(s.charAt(i) == '}' && stack[stackCounter-1] == '{'){
                        stack[stackCounter-1] = 'e';
                        stackCounter--;
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        return stackCounter==0;
    }
}
