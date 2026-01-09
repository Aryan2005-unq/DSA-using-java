class Solution {
    public int characterReplacement(String s, int k) {
        int[] occurances = new int[26];
        int left = 0;
        int maxOccurance = 0;
        int answer = 0;
        for(int right=0;right<s.length();right++){
            maxOccurance = Math.max(maxOccurance,++occurances[s.charAt(right) - 'A']);
            if((right-left+1) - maxOccurance > k){
                occurances[s.charAt(left) - 'A']--;
                left++;
            }
            answer = Math.max(answer,right-left+1);

        }
        return answer;
    }
}


🔹 Character Replacement – Short & Clear Explanation

The goal is to find the longest substring that can be made of one repeating character by replacing at most k characters.

Use a sliding window with two pointers (left and right).

Keep a frequency array to count characters in the current window.

maxOccurance stores the count of the most frequent character in the window.

If

window size − maxOccurance > k


→ too many replacements needed, so shrink the window from the left.

Update the answer with the largest valid window size.
