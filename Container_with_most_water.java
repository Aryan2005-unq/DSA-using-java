class Solution {
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int min_height=0, width =0, water=0;
        while(left<right){
            min_height=Math.min(height[left],height[right]);
            width= right - left;
            water= Math.max(width*min_height,water);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return water;
    }
}
