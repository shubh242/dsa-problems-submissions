class Solution {
    public int maxArea(int[] heights) {
        int area = Integer.MIN_VALUE;
        int i = 0, j = heights.length-1;

        while(i < j){
            int length = Math.min(heights[i], heights[j]);
            int width = (j-i);
            area = Math.max(area, (length*width));
            if(heights[i] >= heights[j]){
                j--;
            }else{
                i++;
            }
        }
        return area;
    }
}
