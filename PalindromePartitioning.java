class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backTrack(result,new ArrayList<>(),0,s);
        return result;

    }
    public void backTrack(List<List<String>> result,List<String> current,int start,String s){
        if(start == s.length()){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int end = start;end<s.length();end++){
            if(isPalindrome(start,end,s)){
                current.add(s.substring(start,end+1));
                backTrack(result,current,end+1,s);
                current.remove(current.size()-1);
            }
        }
    }
    public boolean isPalindrome(int start, int end,String s){
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
