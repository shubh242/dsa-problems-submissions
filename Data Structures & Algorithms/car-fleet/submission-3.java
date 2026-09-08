class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] rate = new double[position.length][2];
        double timeTaken = Double.MIN_VALUE;
        int fleet = 0;

        for(int i = 0; i < position.length; i++) {
            rate[i][0] = (double) target - position[i]; // distance left
            rate[i][1] = (double) (target - position[i])/speed[i]; // time taken to reach the target
        }
        Arrays.sort(rate, (a,b) -> Double.compare(a[0], b[0]));

        for(int i = 0; i < rate.length; i++) {
            // Cars with less time will line up with the car ahead of it making a fleet, thus if the current car's time is less then we dont count it in the fleet.
            if(timeTaken >= rate[i][1]) { 
                continue;
            } else {
                fleet++;
                timeTaken = rate[i][1];
            }
        }
        return fleet;
    }
}
