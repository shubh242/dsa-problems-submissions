class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length-1;
        int maxArea = Integer.MIN_VALUE;

        while(i < j) {
            if(heights[i] < heights[j]) {
                maxArea = Math.max(maxArea, (j-i)*heights[i]);
                i++;
            } else {
                maxArea = Math.max(maxArea, (j-i)*heights[j]);
                j--;
            }
        }
        return maxArea;
    }
}
