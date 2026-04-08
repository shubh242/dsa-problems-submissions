class Solution {
    public int largestRectangleArea(int[] heights) {
        int area = Integer.MIN_VALUE;
        int[] stack = new int[heights.length];
        int[] idxStack = new int[heights.length];
        int stackCounter = 0, j = 0;

        // 3,5,4,8,1,0
        // 0,1,3,

        while(j < heights.length){
            int popped = j;
            while(stackCounter > 0 && stack[stackCounter-1] > heights[j]){
                area = Math.max(area, stack[stackCounter-1] * (j - idxStack[stackCounter-1]));
                stack[stackCounter-1] = 0;
                popped = idxStack[stackCounter-1];
                idxStack[stackCounter-1] = -1;
                stackCounter--;
            }
            stack[stackCounter] = heights[j];
            idxStack[stackCounter] = popped;
            area = Math.max(area, heights[j]);
            stackCounter++;
            j++;
        }

        while(stackCounter > 0){
            area = Math.max(area, (stack[stackCounter-1] * (heights.length-idxStack[stackCounter-1])));
            stackCounter--;
        }
        return area;
    }
}
