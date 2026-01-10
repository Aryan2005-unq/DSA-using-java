class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backTrack(ans,new StringBuilder(),0,0,n);
        return ans;
    }
    public void backTrack(List<String> ans,StringBuilder sb ,int open,int close,int max){
        if(sb.length()==max*2){
            ans.add(sb.toString());
            return ;

        }
        if(open < max){
            sb.append("(");
            backTrack(ans,sb,open+1,close,max);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close < open){
            sb.append(")");
            backTrack(ans,sb,open,close+1,max);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}



What this code does

👉 Generates all valid combinations of n pairs of parentheses using backtracking.

Key idea (1 line)

Build the string step by step, add only valid brackets, and undo the choice after exploring.

Meaning of parameters

ans → stores final valid strings

sb → current string being built

open → number of ( used

close → number of ) used

max → total pairs (n)

Base condition (STOP)
if (sb.length() == max * 2)


✔ All brackets used
✔ Valid string formed
✔ Add to ans and return

Rule 1: Add open bracket (
if (open < max)


You can add ( only if you haven’t used all n

After recursion, remove last ( (backtracking)

Rule 2: Add close bracket )
if (close < open)


You can add ) only if there is an unmatched (

Ensures parentheses are always valid

After recursion, remove last )

Why deleteCharAt() is important

👉 It undoes the last choice so other possibilities can be tried
👉 Without it → wrong answers or extra characters

Example (n = 2)

Generated results:

(())
()()
