class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int num1 = 0;
        int num2 = 0;
        int result = 0;

        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+")) {
                num2 = Integer.parseInt(stack.pop());
                num1 = Integer.parseInt(stack.pop());
                stack.push(""+ (num1 + num2));
            } else if(tokens[i].equals("-")) {
                num2 = Integer.parseInt(stack.pop());
                num1 = Integer.parseInt(stack.pop());
                stack.push(""+ (num1 - num2));
            } else if(tokens[i].equals("*")) {
                num2 = Integer.parseInt(stack.pop());
                num1 = Integer.parseInt(stack.pop());
                stack.push(""+ (num1 * num2));
            } else if(tokens[i].equals("/")){
                num2 = Integer.parseInt(stack.pop());
                num1 = Integer.parseInt(stack.pop());
                if(num2 == 0) {
                    return Integer.MAX_VALUE;
                }
                stack.push(""+ (num1 / num2));
            } else {
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.peek());
    }
}
