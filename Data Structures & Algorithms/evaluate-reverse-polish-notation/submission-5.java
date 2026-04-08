class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int stackCounter = 0;

        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")|| tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                int num1 = stack[stackCounter-1];
                int num2 = stack[stackCounter-2];
                stackCounter -= 2;
                int res = 0;
                if(tokens[i].equals("+")){
                    res = num1 + num2;
                }else if(tokens[i].equals("-")){
                    res = num2 - num1;
                }else if(tokens[i].equals("*")){
                    res = num1 * num2;
                }else if(tokens[i].equals("/")){
                    res = num2 / num1;
                }
                stack[stackCounter] = res;
                stackCounter++;
            }else{
                stack[stackCounter] = Integer.parseInt(tokens[i]);
                stackCounter++;
            }
            System.out.println(Arrays.toString(stack));
        }
        return stack[stackCounter-1];
    }
}
