class Solution {
    public int trap(int[] height) {
        int maxheight = Integer.MIN_VALUE;
        int maxheightIndex = -1;

        for(int i = 0; i < height.length; i++){
            if(maxheight < height[i]){
                maxheight = height[i];
                maxheightIndex = i;
            }
        }
        
        int i = 1, j = height.length-2, startSum = 0, endSum = 0;
        int startMaxHeight = height[0], endMaxHeight = height[j+1];
        while(i < maxheightIndex || j > maxheightIndex){
            // System.out.println("Start = " + startMaxHeight + " " + height[i] + " " + startSum);
            // System.out.println("End = " + endMaxHeight + " " + height[j] + " " + endSum);
            if(startMaxHeight > height[i] && i < maxheightIndex){
                startSum += startMaxHeight - height[i];
            }else{
                startMaxHeight = height[i];
            }

            if(endMaxHeight > height[j] && j > maxheightIndex){
                endSum += endMaxHeight - height[j];
            }else{
                endMaxHeight = height[j];
            }
            i++;
            j--;

            if(i > maxheightIndex){
                i = maxheightIndex+1;
            }

            if(j < maxheightIndex)
                j = maxheightIndex-1;
        }
        return startSum + endSum;
    }
}
