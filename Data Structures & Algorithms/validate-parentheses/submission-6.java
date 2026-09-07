class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int stackCounter = 0;
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack[stackCounter++] = s.charAt(i);
            } else if(stackCounter > 0) {
                if(stack[stackCounter-1] == map.get(s.charAt(i))) {
                    stack[stackCounter-1] = '0';
                    stackCounter--;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stackCounter == 0;
    }
}
