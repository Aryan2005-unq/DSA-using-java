class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        char[] word = s.toCharArray();
        int[] current = new int[len];
        int[] prev = new int[len];
        for(int i=len-1;i>=0;i--){
            current[i] = 1;
            for(int j=i+1;j<len;j++){
                if(word[i]==word[j]){
                    current[j] = prev[j-1] + 2;
                }else{
                    current[j] =  Math.max(prev[j],current[j-1]);
                }
            }
            int[] temp = current;
            current = prev;
            prev = temp;
        }
        return prev[len-1];
    }
}
