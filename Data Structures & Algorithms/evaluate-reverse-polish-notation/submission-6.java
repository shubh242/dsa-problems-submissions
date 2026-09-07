class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int stackCounter = 0;

        // [5,4,0,0,0,0,0,0] - 1
        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int num1 = stack[stackCounter-2];
                int num2 = stack[stackCounter-1];
                stackCounter -= 2;
                if(tokens[i].equals("+")) {
                    stack[stackCounter++] = num1+num2;
                } else if(tokens[i].equals("-")){
                    stack[stackCounter++] = num1-num2;
                } else if(tokens[i].equals("*")) {
                    stack[stackCounter++] = num1*num2;
                } else {
                    stack[stackCounter++] = num1/num2;
                }
            } else {
                stack[stackCounter++] = Integer.parseInt(tokens[i]);
            }
        }
        return stack[stackCounter-1];
    }
}
