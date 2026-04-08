class Solution {
    public int maxArea(int[] heights) {
        int i = 0, j = heights.length-1;
        int maxArea = Integer.MIN_VALUE;

        while(i < j) {
            maxArea = Math.max(maxArea, (Math.min(heights[j], heights[i]) * (j-i)));

            if(heights[i] > heights[j]) {
                j--;
            } else{
                i++;
            }
        }

        return maxArea;
    }
}
