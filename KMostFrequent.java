class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length){
            return nums;
        }
        List<Integer>[] bucket = new List[nums.length+1];
        Map<Integer,Integer> count = new HashMap<>();
        for(int n : nums){
            count.put(n,count.getOrDefault(n,0)+1);
        }
        for(int key : count.keySet()){
            int frequency = count.get(key);
            if(bucket[frequency]==null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        int[] ans = new int[k];
        int counter = 0;
        for(int i = bucket.length-1 ; i>=0 && counter < k;i--){
            if(bucket[i]!=null){
                for(Integer integer : bucket[i]){
                    ans[counter++] = integer;
                }
            }
        }
        return ans;
    }
}
