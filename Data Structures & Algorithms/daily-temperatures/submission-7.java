class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[][] stack = new int[temperatures.length][2];
        int[] result = new int[temperatures.length];
        int stackCounter = 0;

        // (22,0),(21,1),(20,2) - 3
        // 0,0,0

        for(int i = 0; i < temperatures.length; i++) {
            if(i == 0) {
                stack[stackCounter++] = new int[]{temperatures[i], i};
                continue;
            }

            while(stackCounter > 0 && stack[stackCounter-1][0] < temperatures[i]) {
                result[stack[stackCounter-1][1]] = i - stack[stackCounter-1][1];
                stackCounter--;
            }

            stack[stackCounter++] = new int[]{temperatures[i], i};
        }
        return result;
    }
}
