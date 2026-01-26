class Solution {
    public int countSubstrings(String s) {
        int match = 0;
        for(int i=0;i<s.length();i++){
            match += isPalindrome(s,i,i);
            match += isPalindrome(s,i,i+1);
        }
        return match;
    }
    private int isPalindrome(String s, int left, int right){
        int match = 0;
        while(left>=0 && right<s.length()){
            if(s.charAt(left) == s.charAt(right)){
                match++;
                left--;
                right++;
            }else{
                break;
            }
        }
        return match;
    }
}
