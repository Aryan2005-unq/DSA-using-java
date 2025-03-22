// import java.util.*;
// import java.io.*;

class Solution {
    int top=-1;
    char[] arr = new char[10000000];
    public void push(char ch){
        if(top==arr.length - 1){
            System.out.println("Stack full");
        }else{
            top++;
            arr[top]=ch;
        }
    }
    public char pop(){
        if(top==-1){
            return 'a';
        }else{
            char x = arr[top];
            top--;
            return x;
        }
    }
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        char ch;
        for(int i=0;i<arr.length;i++){
            ch=arr[i];
            if(ch=='{' || ch=='[' || ch=='('){
                push(ch);
            }
            else{
                char x=pop();
                    if(x=='a'||(ch=='}' && x!='{')||(ch==']' && x!='[')||(ch==')' && x!='(')){
                         return false;
                    }
                    
            }
        }
        return (top==-1);
        
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the parenthesis string:");
        String s = sc.nextLine();
        Solution obj = new Solution();
        boolean result=obj.isValid(s);
        if(result){
            System.out.println("String has valid parenthesis.");
        }else{
            System.out.println("String doesn't have valid parenthesis.");
        }
        
    }
}