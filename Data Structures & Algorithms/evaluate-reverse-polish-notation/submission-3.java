class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[1000];
        int counter = 0;
        int eval = 0;

        for(int i = 0; i < tokens.length; i++){
            switch(tokens[i]){
                case "+":{
                    stack[counter-2]= (stack[counter-2] + stack[counter-1]);
                    counter -= 1;
                    break;
                }

                case "-":{
                    stack[counter-2] = (stack[counter-2] - stack[counter-1]);
                    counter -= 1;
                    break;
                }
                case "*":{

                    stack[counter-2] = (stack[counter-2] * stack[counter-1]);
                    counter -= 1;
                    // if(i <= 1){
                    //     eval = 1;   
                    // }

                    // if(counter == 1){
                    //     eval *= stack[0];
                    //     counter = 0;
                    // }else{
                    //     stack[counter-2] = (stack[counter-2] * stack[counter-1]);
                    //     counter -= 1;
                    // }
                    break;
                }
                case "/":{
                    stack[counter-2] = (int) Math.floor(stack[counter-2]/stack[counter-1]);
                    counter -= 1;
                    // if(counter == 1){
                    //     eval /= stack[0];
                    //     counter = 0;
                    // }else{
                    //     stack[counter-2] = (int) Math.floor(stack[counter-2]/stack[counter-1]);
                    //     counter -= 1;
                    // }
                    break;
                }

                default: {
                    stack[counter] = Integer.parseInt(tokens[i]);
                    counter++;
                    break;
                }
            }
        }
        return stack[0];
    }
}
