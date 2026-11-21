class Solution {
    public int trap(int[] height) {
        int maxLeftIdx = 0;
        int maxRightIdx = height.length-1;
        int i = 0;
        int j = height.length-1;
        int maxIdx = 0;
        int maxHeight = Integer.MIN_VALUE;
        int leftAmount = 0;
        int rightAmount = 0;

        for(int h = 0; h < height.length; h++) {
            if(maxHeight <= height[h]) {
                maxHeight = height[h];
                maxIdx = h;
            }
        }

        // [0,1,0,2,1,0,1,3,2,1,2,1]
                // 1   1 2 1 0   1    
        // maxIdx = 7
        while(i < maxIdx || j > maxIdx) {
            if(height[i] >= height[maxLeftIdx]) {
                maxLeftIdx = i;
            } else {
                if(i < maxIdx)
                    leftAmount += height[maxLeftIdx] - height[i];
            }

            if(height[j] >= height[maxRightIdx]) {
                maxRightIdx = j;
            } else {
                if(j > maxIdx)
                    rightAmount += height[maxRightIdx] - height[j];
            }

            if(i == maxIdx) {
                i = maxIdx;
            } else {
                i++;
            }

            if(j == maxIdx) {
                j = maxIdx;
            } else {
                j--;
            }
        }
        return leftAmount + rightAmount;
    }
}
