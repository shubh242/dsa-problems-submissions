class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack();
        int maxArea = Integer.MIN_VALUE;
        int poppedIdx = 0;

        for(int i = 0; i < heights.length; i++) {
            poppedIdx = i;
            maxArea = Math.max(maxArea, heights[i]);
            while(!stack.isEmpty() && stack.peek()[0] > heights[i]) {
                int[] tmp = stack.pop();
                maxArea = Math.max(maxArea, (tmp[0] * (i - tmp[1])));
                poppedIdx = tmp[1];
            }
            stack.push(new int[]{heights[i], poppedIdx});
        }

        while(!stack.isEmpty()) {
            int[] tmp = stack.pop();
            maxArea = Math.max(maxArea, tmp[0] * (heights.length-tmp[1]));
        }
        return maxArea;
    }
}
