class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] cars = new double[position.length][2];
        int fleet = 0;

        for(int i = 0; i < position.length; i++) {
            double distance = (double) (target - position[i]);
            double time = (double) (distance / speed[i]);
            cars[i] = new double[]{distance, time};
        }

        // [4,3],[1,3]
        Arrays.sort(cars, (a,b) -> Double.compare(a[0], b[0]));
        double first_car = cars[0][1];

        for(int i = 1; i < cars.length; i++) {
            if(cars[i][1] > first_car) {
                fleet++;
                first_car = cars[i][1];
            }
        }
        return fleet+1;
    }
}
