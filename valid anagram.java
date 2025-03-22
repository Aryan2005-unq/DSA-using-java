class Solution {
    public boolean isAnagram(String s, String t) {
       char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1,arr2); 
    }
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 1st string :");
        String s = sc.nextLine();
        System.out.println("Enter the 2nd string :");
        String t = sc.nextLine();
        Solution obj = new Solution();
        if(obj.isAnagram(s,t)){
            System.out.println("The strings are anagrams");
        }
        else{
            System.out.println("The strings are not anagrams");
        }

        

    }
}