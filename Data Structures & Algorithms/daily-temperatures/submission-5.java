class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] stack = new int[temperatures.length];
        int[] result = new int[temperatures.length];
        int stackCounter = 0;

        for(int i = 0; i < temperatures.length; i++){
            while(stackCounter > 0 && temperatures[stack[stackCounter-1]] < temperatures[i]){
                result[stack[stackCounter-1]] = i - stack[stackCounter-1];
                stackCounter--;
            }
            stack[stackCounter] = i;
            stackCounter++;
        }
        return result;
    }
}
