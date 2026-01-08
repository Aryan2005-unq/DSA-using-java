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




🧠 Top K Frequent Elements – Simple Summary

The goal is to find the k numbers that appear most frequently.

This solution uses Bucket Sort instead of sorting the whole array.

🔁 Step-by-Step Logic
1️⃣ Edge Case

If k equals the array length, return the array directly.

2️⃣ Count Frequencies

Use a HashMap to count how many times each number appears.

📌 Example:

nums = [1,1,1,2,2,3]
count = {1=3, 2=2, 3=1}

3️⃣ Create Buckets

Create an array of lists called bucket.

Index = frequency

Value = numbers with that frequency

📌 Example:

bucket[1] → [3]
bucket[2] → [2]
bucket[3] → [1]

4️⃣ Collect Top K Elements

Traverse buckets from highest frequency to lowest.

Add elements to the result array until k elements are collected.
