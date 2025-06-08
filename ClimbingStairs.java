class Solution {
    public int climbStairs(int n) {
        int a=1,b=0;
        int m=a+b;
        while(n>0){
            a = m;
            m = m + b;
            b = a;
            n--;
        }
        return m;
    }
}
