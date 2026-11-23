class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] c = s.toCharArray();

        for(int i = 0; i < c.length; i++) {
            if(c[i] == '(' || c[i] == '{' || c[i] == '[') {
                stack.push(c[i]);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                if(c[i] == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if(c[i] == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if(c[i] == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
