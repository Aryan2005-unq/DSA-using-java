class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1,right = 1;
        for(int pile : piles){
            right = Math.max(right,pile);
        }
        while(left < right){
            int mid = left + (right - left)/2;
            if(isEatingFeasible(piles,mid,h)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean isEatingFeasible(int[] piles , int speed , int h){
        int hours = 0;
        for(int pile : piles){
            hours += Math.ceil((double) pile / speed);
        }
        return hours <= h;
    }
}



🔹 Koko Eating Bananas — Last-Moment Explanation

Goal: Find the minimum eating speed so Koko can finish all banana piles within h hours.

Use binary search on the answer (speed).

🧠 How it works
1️⃣ Search Space

left = 1 → minimum possible speed

right = max(piles) → maximum speed needed (eat a whole pile in 1 hour)

2️⃣ Binary Search

Pick mid as the current speed.

Check if Koko can finish within h hours at speed mid.

if (feasible) → try smaller speed (right = mid)
else → need faster speed (left = mid + 1)

3️⃣ Feasibility Check

For each pile, hours needed is:

ceil(pile / speed)


Sum total hours.

If total hours ≤ h, the speed works.

4️⃣ Result

When left == right, that value is the minimum valid speed.
