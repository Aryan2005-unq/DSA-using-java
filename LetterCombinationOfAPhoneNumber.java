class Solution {
    private String[] letterArray = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        backTrack(digits,"",result,0);
        return result;
    }
    public void backTrack(String digits,String combination,List<String> result,int index){
        if(index==digits.length()){
            result.add(combination);
            return;
        }
        String letters = letterArray[digits.charAt(index)-'0'];
        for(char letter : letters.toCharArray()){
            backTrack(digits,combination+letter,result,index+1);
        }
    }
}
