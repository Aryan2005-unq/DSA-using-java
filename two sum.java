class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] count = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int sum = nums[i]+nums[j];
                if(sum==target){
                    count[0]=i;
                    count[1]=j;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i,j;
        
        System.out.println("Enter the size of the array:");
        int n= sc.nextInt();
        int[] nums = new int[n];
        for(i=0;i<n;i++){
        System.out.println("Enter the element"+ i+1 +"of the array:");
         nums[i]= sc.nextInt();
        }
        System.out.println("Enter the target:");
        int target = sc.nextInt();
        Solution obj = new Solution();
        int[] result = obj.twoSum(nums,target);
        System.out.println("The indices are:");
        for(j=0;j<result.length;j++){
            System.out.println(result[j]);
        }
    }
}