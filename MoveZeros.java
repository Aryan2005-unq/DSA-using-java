class Solution {
    public void moveZeroes(int[] nums) {
        int j = -1, i = 0;
        for(i=0;i<nums.length;i++){
            if(nums[i]==0){
                j=i;
                break;
            }
        }
        for(i=j+1;i<nums.length;i++){
            if(nums[i]!=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
             }
        }
    }
}
