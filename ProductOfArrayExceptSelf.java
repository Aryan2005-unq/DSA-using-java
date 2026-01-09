class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int pre =1,post =1;
        for(int i=0;i<nums.length;i++){
            result[i] = pre;
            pre*= nums[i];
        }
        for(int i=nums.length-1;i>=0;i--){
            result[i] = post*result[i];
            post *= nums[i];
        }
        return result;
    }
}



🧠 Product of Array Except Self – Simple Summary

The goal is to compute, for each index, the product of all elements except itself.

Division is not used.

The solution runs in O(n) time and O(1) extra space (excluding output array).

🔁 Step-by-Step Logic
1️⃣ Prefix Pass (Left to Right)

Maintain a variable pre (product of elements to the left).

Store pre in result[i].

Update pre by multiplying current element.

📌 After this pass:

result[i] contains product of all elements before index i.

2️⃣ Postfix Pass (Right to Left)

Maintain a variable post (product of elements to the right).

Multiply result[i] with post.

Update post by multiplying current element.

📌 After this pass:

result[i] becomes product of all elements except itself.
