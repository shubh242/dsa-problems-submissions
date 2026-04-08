class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxElement = Integer.MIN_VALUE;
        int res = Integer.MAX_VALUE;

        for(int i = 0; i < piles.length; i++){
            maxElement = Math.max(maxElement, piles[i]);
        }

        int left = 1;
        int right = maxElement;
        int mid = (maxElement+left)/2;
        int counter = 0;

        while(left <= right){
            for(int i = 0; i < piles.length; i++){
                if(piles[i] <= mid)
                    counter += 1;
                else{
                    counter += piles[i]%mid == 0 ? piles[i]/mid : (piles[i]/mid)+1;
                }
                if(counter > h)
                    break;    
            }

            if(counter > h){
                left = mid+1;
            }else{
                res = Math.min(res, mid);
                right = mid-1;
            }
            mid = (right+left)/2;
            counter = 0;
        }
        return res;
    }
}
