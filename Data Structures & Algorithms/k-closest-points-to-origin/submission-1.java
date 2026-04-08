class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>(){
            public int compare(double[] a, double[] b){
                if(a[2] == b[2]){
                    return 0;
                }else if(a[2] < b[2]){
                    return -1;
                }else{
                    return 1;
                }
            }
        });

        double[][] s = new double[points.length][3];

        for(int i = 0; i < points.length; i++){
            double x = (double) points[i][0];
            double y = (double) points[i][1];
            double distance = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
            s[i] = new double[]{x, y, distance};
            pq.add(new double[]{x, y, distance});
        }

        int[][] closest = new int[k][2];
        
        while(k > 0){
            double[] temp = pq.poll();
            System.out.println(Arrays.toString(temp));
            closest[k-1] = new int[]{(int)temp[0], (int)temp[1]};
            k--;
        }
        System.out.println(Arrays.toString(pq.peek()));
        return closest;
    }
}
