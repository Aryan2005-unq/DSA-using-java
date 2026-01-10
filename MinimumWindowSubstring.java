class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0 || t.length()==0 || s.length() < t.length()){
            return "";
        }
        Map<Character,Integer> tMap = new HashMap<>();
        for(int i =0;i<t.length();i++){
            tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0)+1);
        }
        int l = 0,r = 0;
        int[] ans = {-1,0,0};
        int required = tMap.size();
        int created = 0;
        Map<Character,Integer> subStringMap = new HashMap<>();
        while(r<s.length()){
            char c = s.charAt(r);
            subStringMap.put(c,subStringMap.getOrDefault(c,0)+1);
            if(tMap.containsKey(c) &&  
                tMap.get(c).intValue() == subStringMap.get(c).intValue()){
                    created++; 
            }
            while(l<=r && required == created){
                c = s.charAt(l);
                if(ans[0]==-1 || ans[0]>=r-l+1){
                    ans[0] = r -l +1;
                    ans[1] = l;
                    ans[2] = r;
                }
                subStringMap.put(c,subStringMap.get(c)-1);
                if(tMap.containsKey(c) &&  
                    tMap.get(c).intValue() > subStringMap.get(c).intValue()){
                        created--;
                    }
                l++;
            }
            r++;
        }
        if(ans[0]==-1){
            return "";
        }else{
            return s.substring(ans[1],ans[2]+1);
        }
    }
}





🔹 Minimum Window Substring — Last-Moment Revision

Build a frequency map (tMap) for string t.

Use a sliding window with two pointers l and r on string s.

required = tMap.size() → number of unique characters needed.

created counts how many required characters are currently satisfied.

Expand window by moving r, update counts in subStringMap.

When a character’s count matches exactly with tMap, increment created.

While created == required, try to shrink window from the left to get the minimum length.

Update the answer whenever a smaller valid window is found.

If a required character count drops below needed, decrement created.

Return the smallest valid substring, or "" if none exists.
