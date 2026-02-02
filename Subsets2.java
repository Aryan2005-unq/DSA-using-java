class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        generateSubset(0,nums,new ArrayList<>(),result);
        return result;
    }
    private void generateSubset(int index, int[] nums,List<Integer> current,List<List<Integer>> result){
        result.add(new ArrayList<>(current));
        for(int i = index;i<nums.length;i++){
            if(index < i && nums[i]==nums[i-1]){
                continue;
            }
            current.add(nums[i]);
            generateSubset(i+1,nums,current,result);
            current.remove(current.size()-1);
        }
    }
}
