class Solution {
    public boolean canJump(int[] nums) {
        int finale = nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(i+nums[i]>=finale){
                finale = i;
            }
        }
        return finale == 0 ? true : false;
    }
}
