class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxBunch = Integer.MIN_VALUE;

        for(int i = 0; i < piles.length; i++){
            maxBunch = Math.max(maxBunch, piles[i]);
        }
        // 1,2,3,4, ......, 12, 13, 14, ......, 25
        int left = 1, right = maxBunch, mid = (left+right)/2;
        int pile = Integer.MAX_VALUE;

        while(left <= right){
            int hours = isValid(piles, h, mid);
            System.out.println(hours);
            if(hours <= h){
                pile = Math.min(pile, mid);
                right = mid-1;
            }else{
                left = mid+1;
            }
            mid = (left+right)/2;
        }
        return pile == Integer.MAX_VALUE ? maxBunch : pile;
    }

    public int isValid(int[] piles, int h, int b){
        int hours = 0;
        for(int i = 0; i < piles.length; i++){
            if(piles[i] > b){
                hours += piles[i] / b + (piles[i]%b > 0 ? 1:0);
            }else{
                hours += 1;
            }
            if(hours > h)
                return hours;
        }
        return hours;
    }
}
