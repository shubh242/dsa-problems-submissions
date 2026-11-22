class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<int[]> dq = new LinkedList<>();
        int i = 0;
        int j = 0;
        int[] result = new int[nums.length-k+1];
        int counter = 0;

        while(j < nums.length) {
            // [(6,6)]
            // [2,2,4,4,6]
            // i=4  j=7
            if((j-i+1) <= k) {
                while(!dq.isEmpty() &&  dq.peekLast()[0] < nums[j]) {
                    dq.pollLast();
                }
                dq.offerLast(new int[]{nums[j], j});
                if((j-i+1) == k) {
                    result[counter++] = dq.peekFirst()[0];
                }
                j++;
            } else {
                i++;
                while(!dq.isEmpty() && dq.peekFirst()[1] < i) {
                    dq.pollFirst();
                }

                while(!dq.isEmpty() && dq.peekLast()[0] < nums[j]) {
                    dq.pollLast();
                }
                dq.offerLast(new int[]{nums[j], j});
                result[counter++] = dq.peekFirst()[0];
                j++;
            }
        }
        return result;
    }
}
