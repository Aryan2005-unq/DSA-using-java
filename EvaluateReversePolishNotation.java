import java.util.Stack;
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token:tokens){
            if(isOperator(token)){
                int b = stack.pop();
                int a = stack.pop();
                int result = operation(a,b,token);
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    private boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
    private int operation(int a, int b, String operator){
        switch(operator){
            case "+" : return a + b;
            case "-" : return a - b;
            case "*" : return a * b;
            case "/" : return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
