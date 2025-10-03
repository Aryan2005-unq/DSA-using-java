class Solution {
    public int longestConsecutive(int[] nums) {
         int count= 1;
        int temp=1;
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]+1 == nums[i+1]){
                count++;
            }else if(nums[i]==nums[i+1]){
                continue;                
            }else{
                temp = Math.max(count,temp);
                count=1;
            }
        }
        return Math.max(temp,count);
    }
}
