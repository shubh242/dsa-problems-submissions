class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;

        for(int i = 0; i < piles.length; i++) {
            maxPile = Math.max(maxPile, piles[i]);
        }

        if(h == piles.length) {
            return maxPile;
        }

        int low = 1;
        int high = maxPile;
        int minRate = Integer.MAX_VALUE;

        while(low <= high) {
            int mid = (low+high)/2;
            int totalHours = 0;
            for(int i = 0; i < piles.length; i++) {
                if(piles[i] <= mid) {
                    totalHours+=1;
                } else {
                    totalHours += piles[i]/mid + (piles[i]%mid >= 1 ? 1: 0);
                }
                if(totalHours > h) {
                    break;
                }
            }

            if(totalHours <= h) {
                minRate = Math.min(minRate, mid);
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return minRate;
    }
}
