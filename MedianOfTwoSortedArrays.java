class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int x = nums1.length;
        int y = nums2.length;
        int start = 0, end = x;
        while(start <= end){
            int XPart = (start + end)/2;
            int YPart = (x+y+1) / 2 - XPart;

            int xLeft = XPart == 0? Integer.MIN_VALUE : nums1[XPart-1];
            int xRight = XPart == x? Integer.MAX_VALUE : nums1[XPart];
            int yLeft = YPart == 0? Integer.MIN_VALUE : nums2[YPart-1];
            int yRight = YPart == y? Integer.MAX_VALUE : nums2[YPart];
            
            if(xLeft <= yRight && yLeft <= xRight){
                if((x+y)%2 == 0){
                    return ((double)(Math.max(xLeft,yLeft) + Math.min(xRight,yRight))/2);
                }else{
                    return Math.max(xLeft,yLeft);
                }
            }else if(xLeft > yRight){
                end = XPart - 1;
            }else{
                start = XPart + 1;
            }
        }
        return 0;
    }
}



🔹 Median of Two Sorted Arrays — Last-Moment Revision

Goal: Find the median of two sorted arrays in O(log min(n, m)) time.

Always perform binary search on the smaller array (swap if needed).

🧠 Core Idea (Partition Logic)

Partition both arrays such that:

Left half contains (x + y + 1) / 2 elements.

All elements on the left ≤ all elements on the right.

🔁 Steps

Binary search on nums1 (smaller array).

Pick partition XPart in nums1, calculate YPart in nums2.

Define boundary values:

xLeft, xRight, yLeft, yRight

Use ±∞ when partition touches array ends.

Check validity:

xLeft ≤ yRight AND yLeft ≤ xRight


If valid:

Odd total length → median = max(xLeft, yLeft)

Even total length → median =

(max(xLeft, yLeft) + min(xRight, yRight)) / 2


If not valid:

Move left or right in binary search accordingly.
