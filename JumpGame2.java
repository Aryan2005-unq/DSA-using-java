class Solution {
    public int jump(int[] nums) {
        int jump = 0,currentMax = 0,currentEnd = 0;
        for(int i=0;i<nums.length-1;i++){
            currentMax = Math.max(currentMax,i+nums[i]);
            if(i == currentEnd){
                jump++;
                currentEnd = currentMax;
            }
        }
        return jump;
    }
}
