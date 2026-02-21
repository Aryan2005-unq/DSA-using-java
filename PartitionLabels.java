class Solution {
    public List<Integer> partitionLabels(String s) {
        int partitionStart = 0;
        int partitionEnd = 0;
        List<Integer> result = new ArrayList<>();
        int[] occurences = new int[26];
        for(int i=0;i<s.length();i++){
            occurences[s.charAt(i) - 'a'] = i;
        }
        for(int i=0;i<s.length();i++){
            partitionEnd = Math.max(partitionEnd,occurences[s.charAt(i)-'a']);
            if(i == partitionEnd){
                result.add(partitionEnd - partitionStart + 1);
                partitionStart = i+1;
            }
        }
        return result;
    }
}
