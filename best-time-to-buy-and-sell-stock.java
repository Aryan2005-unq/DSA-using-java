class Solution {
    public int maxProfit(int[] prices) {
        int max=0,min=32767;
        int i;
        for(i=0;i<prices.length;i++){
            if(prices[i]<min){
                min = prices[i];
            }
            else if(prices[i]-min > max){
                max = prices[i]-min;
            }
        }
        return max;
        
       
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int i,j;
        System.out.println("Enter the Size of the array:");
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(i=0;i<n;i++){
            System.out.println("Enter the element " + (i+1) + ":");
            prices[i]= sc.nextInt();
        }
        Solution obj = new Solution();
        int result=obj.maxProfit(prices);
        
        System.out.println("Maximum profit is "+result);
        
    }
}