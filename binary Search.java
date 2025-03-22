class Solution {
    public int search(int[] nums, int target) {
        int low=0,high=nums.length-1;
        int mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the sorted array:");
        int n= sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter the element" +(i+1)+ ":");
            nums[i]= sc.nextInt();
        }
        System.out.println("Enter the target element:");
        int target= sc.nextInt();
        Solution obj = new Solution();
        int result=obj.search(nums,target);
        if(result!=-1){
            System.out.println("Element found at index location " +result);
        }else{
            System.out.println("Element not found.");
        }
        
    }
}