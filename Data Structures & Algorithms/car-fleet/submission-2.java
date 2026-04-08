class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] rate = new double[speed.length][2];
        int fleet = 0;
        double timeTaken = Double.MIN_VALUE;

        for(int i = 0; i < position.length; i++){
            rate[i][0] = (double) (target - position[i]);
            rate[i][1] =  ((double)(target - position[i])/(double)speed[i]);
        }

        Arrays.sort(rate, new Comparator<double[]>(){
            public int compare(double[] a, double[] b){
                return Double.compare(a[0], b[0]);
            }
        });

        // 2-1, 4-1.33333
        for(int i = 0; i < rate.length; i++){
            if(timeTaken >= rate[i][1]){
                continue;
            }else{
                fleet++;
                timeTaken = rate[i][1];
            }
        }
        return fleet;
    }
}
