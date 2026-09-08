class Solution {
    public int largestRectangleArea(int[] heights) {
        int[][] stack = new int[heights.length][2];
        int stackCounter = 0;
        int i = 0;
        int area = Integer.MIN_VALUE;

        while(i < heights.length) {
            int popped = i;
            while(stackCounter > 0 && stack[stackCounter-1][0] > heights[i]) {
                area = Math.max(area, stack[stackCounter-1][0] * (i-stack[stackCounter-1][1]));
                popped = stack[stackCounter-1][1];
                stackCounter--;
            }
            stack[stackCounter++] = new int[]{heights[i], popped};
            area = Math.max(area, heights[i]);
            i++;
        }

        while(stackCounter != 0) {
            area = Math.max(area, stack[stackCounter-1][0] * (heights.length - stack[stackCounter-1][1]));
            stackCounter--;
        }
        return area;
    }
}
