class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Integer.MIN_VALUE;
        int pile = Integer.MAX_VALUE;

        for(int i = 0; i < piles.length; i++) {
            end = Math.max(end, piles[i]);
        }

        while(start <= end) {
            int mid = (start + end) / 2;
            int hours = calcHours(piles, mid, h);
            if(hours <= 0) {
                break;
            }

            if(hours > h) {
                start = mid+1;
            } else if(hours <= h) {
                pile = Math.min(pile, mid);
                end = mid - 1;
            }
            // System.out.println(hours + " " + mid + " " + start + " " + end);
        }
        return pile;
    }

    public int calcHours(int[] piles, int pile, int h) {
        int hours = 0;

        for(int i = 0; i < piles.length; i++) {
            hours += (piles[i] / pile) + (piles[i]%pile > 0 ? 1 : 0);
        }
        return hours;
    }
}
