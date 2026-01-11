class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] cars = new double[position.length][2];
        for(int i=0;i<position.length;i++){
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }
        Arrays.sort(cars,(a,b) -> Double.compare(b[0],a[0]));
        double previous = 0;
        int count = 0;
        for(double[] car : cars){
            if(car[1] > previous){
                count++;
                previous = car[1];
            }
        }
        return count;
    }
}



🔹 Car Fleet — Last-Moment Revision Explanation

Each car is represented as (position, time to reach target).

Time is calculated as

(target − position) / speed


Cars are sorted by position in descending order (closest to target first).

Traverse cars from front to back:

Keep track of the maximum time (previous) seen so far.

If a car’s time is greater than previous, it cannot catch up → forms a new fleet.

Otherwise, it joins the fleet ahead.

Count how many times a new fleet is formed.
