class MedianFinder {

    PriorityQueue<Integer> maxSmallHeap;
    PriorityQueue<Integer> minBigHeap;

    public MedianFinder() {
        this.maxSmallHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.minBigHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(this.maxSmallHeap.size() > 0 && num > this.maxSmallHeap.peek()){
            this.minBigHeap.offer(num);
        }else{
            this.maxSmallHeap.offer(num);
        }

        while(Math.abs(this.maxSmallHeap.size() - this.minBigHeap.size()) > 1){
            if(this.maxSmallHeap.size() > this.minBigHeap.size()){
                int temp = this.maxSmallHeap.poll();
                this.minBigHeap.offer(temp);
            }else{
                int temp = this.minBigHeap.poll();
                this.maxSmallHeap.offer(temp);
            }
        }
    }
    
    public double findMedian() {
        int small = this.maxSmallHeap.size();
        int big = this.minBigHeap.size();

        if((small + big)%2 == 1){
            if(small > big)
                return (double) this.maxSmallHeap.peek();
            else
                return (double) this.minBigHeap.peek();
        }else{
            return (double) (this.maxSmallHeap.peek() + this.minBigHeap.peek())/2;
        }
    }
}
