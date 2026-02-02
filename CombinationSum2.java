class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(target , result , combination, 0, candidates);
        return result;
    }
    public void backTrack(int target, List<List<Integer>> result, List<Integer> combination, int start, int[] candidates){
        if(target == 0){
            result.add(new ArrayList<>(combination));
        }
        for(int i=start;i<candidates.length;i++){
            if(i > start && candidates[i]==candidates[i-1]){
                continue;
            }else if(target - candidates[i] < 0){
                return;
            }
            combination.add(candidates[i]);
            backTrack(target-candidates[i],result,combination,i+1,candidates);
            combination.remove(combination.size()-1);
        }
    }
}
