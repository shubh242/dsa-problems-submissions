class Solution {
    public int maxArea(int[] heights) {
        int i = 0, j = heights.length-1, area = Integer.MIN_VALUE;
        
        while(i < j){
            area = Math.max(area, (Math.min(heights[i], heights[j]) * (j-i)));
            if(heights[i] < heights[j]){
                i++;
            }else{
                j--;
            }
        }
        return area;
    }
}
