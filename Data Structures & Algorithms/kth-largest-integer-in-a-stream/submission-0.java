class KthLargest {
    
    PriorityQueue<Integer> pq;
    int k = 0;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++)
            this.pq.add(nums[i]);
        this.k = k;
    }
    
    public int add(int val) {
        this.pq.add(val);
        int i = 0, num = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>(this.pq);
        if(q.size() < k){
            i = q.size();
        }else{
            i = q.size() - this.k;
        }

        while(i >= 0){
            num = q.poll();
            i--;
        }

        return num;
    }
}
