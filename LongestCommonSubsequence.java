class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        char[] first = text1.toCharArray();
        char[] second = text2.toCharArray();
        int[] prev = new int[n+1];
        int[] current = new int[n+1];
        Arrays.fill(prev,0);
        Arrays.fill(current,0);
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(first[i-1] == second[j-1]){
                    current[j] = prev[j-1] + 1;
                }else{
                    current[j] = Math.max(current[j-1],prev[j]);
                }
            }
            prev = current;
            current = new int[n+1];
            Arrays.fill(current,0);
        }
        return prev[n];
    }
}
