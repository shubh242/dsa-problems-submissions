class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[2]));

        for(int i = 0; i < points.length; i++){
            int x = points[i][0];
            int y = points[i][1];

            pq.offer(new int[]{x,y,(int)(Math.pow(x,2) + Math.pow(y,2))});
        }

        int[][] res = new int[k][2];
        while(k > 0){
            int[] temp = pq.poll();
            res[k-1][0] = temp[0];
            res[k-1][1] = temp[1];
            k--;
        }
        return res;
    }
}
