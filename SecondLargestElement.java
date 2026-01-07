class Solution {
    public int secondLargestElement(int[] nums) {
        int largest = num[0];
        int slargest = Integer.MIN_VALUE;
        for(int i = 1;i<nums.length ; i++){
            if(num[i] > largest){
                largest = num[i];
                slargest = largest;
            }else if(num[i] < largest && num[i] > slargest){
                slargest = num[i]
            }
        }
        return slargest;
    }
} 
