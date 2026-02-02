class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTrack(result,used,nums,new ArrayList<>());
        return result;
    }
    public void backTrack(List<List<Integer>> result,boolean[] used,int[] nums,List<Integer> combination){
        if(combination.size() == nums.length){
            result.add(new ArrayList<>(combination));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                combination.add(nums[i]);
                used[i] = true;
                backTrack(result,used,nums,combination);
                used[i] = false;
                combination.remove(combination.size() - 1);
            }
        }
    }
}
