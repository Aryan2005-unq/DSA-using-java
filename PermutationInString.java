class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];
        if(s1.length() > s2.length()){
            return false;
        }
        for(int i=0;i<s1.length();i++){
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }
        for(int i=0;i<s2.length() - s1.length();i++){
            if(matches(s1Map,s2Map)){
                return true;
            }
                s2Map[s2.charAt(i + s1.length()) - 'a']++;
                s2Map[s2.charAt(i) - 'a']--;
            }
            return matches(s1Map,s2Map);
        }
    private boolean matches(int[] s1Map , int[] s2Map){
        for(int i=0;i<s1Map.length;i++){
            if(s1Map[i]!=s2Map[i]){
                return false;
            }
        }
        return true;
    }
}





🧠 Check Inclusion – Explanation
🔹 Goal

Check if any permutation of s1 exists as a substring in s2.

🔁 Core Idea

Use a sliding window of size s1.length() on s2.

Compare character frequency arrays of s1 and the current window in s2.

🔍 Step-by-Step Logic
1️⃣ Frequency Arrays
int[] s1Map = new int[26];
int[] s2Map = new int[26];


Store character counts for s1 and current window of s2.

2️⃣ Length Check
if (s1.length() > s2.length()) return false;


If s1 is longer, permutation is impossible.

3️⃣ Initialize First Window
for (int i = 0; i < s1.length(); i++) {
    s1Map[s1.charAt(i) - 'a']++;
    s2Map[s2.charAt(i) - 'a']++;
}


Count characters of s1.

Count characters of the first window in s2.

4️⃣ Slide the Window
for (int i = 0; i < s2.length() - s1.length(); i++) {


If frequency maps match → permutation found → return true.

Move window:

Add next character (right side)

Remove leftmost character

s2Map[s2.charAt(i + s1.length()) - 'a']++;
s2Map[s2.charAt(i) - 'a']--;

5️⃣ Final Check
return matches(s1Map, s2Map);


Ensures the last window is also checked.

🧩 Helper Method matches()

Compares both frequency arrays.

Returns true if all character counts are equal.
