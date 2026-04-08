class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] stack = new int[temperatures.length];
        int stackCounter = 0;
        int idx = 0;
        int[] result = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++){

            while(stackCounter != 0 && temperatures[stack[stackCounter-1]] < temperatures[i]){
                idx = stack[stackCounter-1];
                stack[stackCounter-1] = 0;
                stackCounter--;
                result[idx] =  i - idx;
                if(stackCounter == 0)
                    break;
            }
            stack[stackCounter] = i;
            stackCounter++;
        }
        return result;
    }
}
