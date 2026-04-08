class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            if(stk.isEmpty()){
                stk.push(i);
                continue;
            }

            while(temperatures[stk.peek()] < temperatures[i]){
                // System.out.println(j + " " + stk.toString() + " " + temperatures[stk.peek()] + " " + Arrays.toString(result));
                int idx = (int) stk.pop();
                result[idx] =  i - idx;
                if(stk.isEmpty())
                    break;
            }
            stk.push(i);
        }
        return result;
    }
}
