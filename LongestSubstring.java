class Solution { 
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> seenAlready = new HashMap<>();
        int left = 0;
        int maxLength=0;
        if(s==null || s.length()==0){
            return 0;
        }
        for(int right=0;right< s.length();right++){
            while(seenAlready.containsKey(s.charAt(right))){
                seenAlready.remove(s.charAt(left));
                left++;
            }
            seenAlready.put(s.charAt(right),right);
            maxLength = Math.max(maxLength, right- left+1);
        }
        return maxLength;
    }
}
