class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] heightStack = new int[heights.length];
        int[] indexStack = new int[heights.length];
        int stackCounter = 0;
        int maxArea = Integer.MIN_VALUE;
        int n = heights.length;
        int tempIndex = -1;

        for(int i = 0; i < heights.length; i++){
            tempIndex = -1;
            if(stackCounter == 0){
                heightStack[stackCounter] = heights[i];
                indexStack[stackCounter] = i;
                stackCounter++;
                maxArea = Math.max(heights[i], maxArea);
                continue;
            }

            while(heightStack[stackCounter-1] > heights[i]){
                maxArea = Math.max(maxArea, (heightStack[stackCounter-1] * (i-indexStack[stackCounter-1])));
                heightStack[stackCounter-1] = 0;
                tempIndex = indexStack[stackCounter-1];
                indexStack[stackCounter-1] = 0;
                stackCounter--;
                if(stackCounter == 0){
                    break;
                }
            }

            heightStack[stackCounter] = heights[i];
            indexStack[stackCounter] = (tempIndex != -1) ? tempIndex : i;
            stackCounter++;
            System.out.println(Arrays.toString(heightStack) + " " + Arrays.toString(indexStack));
        }

        while(stackCounter != 0){
            maxArea = Math.max((heightStack[stackCounter-1] * (n-indexStack[stackCounter-1])), maxArea);
            heightStack[stackCounter-1] = 0;
            indexStack[stackCounter-1] = 0;
            stackCounter--;
        }
        return maxArea;
    }
}
