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


🧠 Move Zeroes – Simple Summary

The goal is to move all 0s to the end of the array.

The order of non-zero elements is preserved.

The operation is done in-place (no extra array).

🔁 Step-by-step Logic

Find the index of the first zero and store it in j.

Start scanning the array after that zero.

Whenever a non-zero element is found:

Swap it with the element at index j.

Move j forward.

🔍 What j Represents

j always points to the position where the next non-zero element should go.
