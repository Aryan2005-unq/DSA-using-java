class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList();
        }
        int[] arr = new int[26];
        Map<String,List> ansMap = new HashMap<>();
        for(String s:strs){
            Arrays.fill(arr,0);
            for(char c:s.toCharArray()){
                arr[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
                sb.append("#");
                sb.append(arr[i]);
            }
            String key = sb.toString();
            if(!ansMap.containsKey(key)){
                ansMap.put(key,new ArrayList());
            }
            ansMap.get(key).add(s);
        }
        return new ArrayList(ansMap.values());
    }
}


🧠 Group Anagrams – Simple Summary

If the input array is empty, return an empty list.

Create an integer array of size 26 to count letters from a to z.

Use a HashMap:

Key → unique string made from character counts

Value → list of words (anagrams)

🔁 For each word in the array:

Reset the count array to zero.

Count how many times each character appears in the word.

Convert the count array into a unique string key using StringBuilder.

If the key is not in the map, create a new list.

Add the word to the list for that key.

✅ Final Step:

Return all the grouped lists from the HashMap.
