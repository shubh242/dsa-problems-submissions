class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length-1;
        int mostWater = Integer.MIN_VALUE;

        while(i < j) {
            mostWater = Math.max(mostWater, Math.min(heights[i], heights[j]) * (j-i));
            if(heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return mostWater;
    }
}
