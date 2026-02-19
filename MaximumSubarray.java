class Solution {
    public int maxSubArray(int[] nums) {
        int currentMax = 0;
        int maxSum = nums[0];
        for(int i=0;i<nums.length;i++){
            if(currentMax<0){
                currentMax = 0;
            }
            currentMax += nums[i];
            maxSum = Math.max(currentMax,maxSum);
        }
        return maxSum;
    }
}
