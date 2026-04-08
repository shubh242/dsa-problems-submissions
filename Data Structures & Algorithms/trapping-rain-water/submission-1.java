class Solution {
    public int trap(int[] height) {
        int maxHeight = Integer.MIN_VALUE;
        int maxHeightIndex = -1;
        for(int i = 0; i < height.length; i++){
            if(maxHeight < height[i]){
                maxHeight = height[i];
                maxHeightIndex = i;
            }
        }
        int i = 0, j = height.length-1, startMax = height[0], endMax = height[j];
        int startSum = 0, endSum = 0;
        while(i < maxHeightIndex || j > maxHeightIndex){
            if(startMax > height[i] && i < maxHeightIndex){
                startSum += startMax - height[i];
            }else if(i < maxHeightIndex){
                startMax = height[i];
            }

            if(endMax > height[j] && j > maxHeightIndex){
                endSum += endMax - height[j];
            }else if(j > maxHeightIndex){
                endMax = height[j];
            }

            i++;
            j--;

            if(i >= maxHeightIndex){
                i = maxHeightIndex;
            }
            if(j <= maxHeightIndex){
                j = maxHeightIndex;
            }
        }
        return startSum + endSum;
    }
}
