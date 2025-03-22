class Solution {
    public boolean isPalindrome(String s) {
        String result= s.replaceAll("[^a-zA-Z0-9]","");
        char[] arr= result.toCharArray();
        int count=0;
        for(int i=0;i<arr.length;i++){
        
         arr[i]= Character.toLowerCase(arr[i]);
        }
        if(arr.length==0){
            return true;
        }
        for(int i=0;i<=(arr.length)/2;i++){
            if(arr[i]==arr[arr.length-i-1]){
                count++;
            }else{
                count=0;
                break;
            }
            
        }
        if(count!=0){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String:");
        String s= sc.nextLine();
        Solution obj = new Solution();
        boolean result= obj.isPalindrome(s);
        if(result){
            System.out.println("String is Palindrome.");
        }else{
            System.out.println("String is not a Palindrome.");
        }
        
        
    }
}