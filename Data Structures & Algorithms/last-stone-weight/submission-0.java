class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int s: stones){
            pq.add(s);
        }

        int remains = 0;
        while(pq.size() > 1){
            remains = pq.poll() - pq.poll();
            pq.add(remains);
        }

        return pq.poll();
    }
}
