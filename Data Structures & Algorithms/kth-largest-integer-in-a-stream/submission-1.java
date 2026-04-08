class KthLargest {
    List<Integer> arr;
    int k;
    public KthLargest(int k, int[] nums) {
        this.arr = new ArrayList<>();
        this.k = k;
        for(int i = 0; i < nums.length; i++)
            this.arr.add(nums[i]);
    }
    
    public int add(int val) {
        this.arr.add(val);
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        pq.addAll(this.arr);
        int i = 0;
        while(i < this.k-1){
            pq.poll();
            i++;
        }
        return pq.poll();
    }
}
