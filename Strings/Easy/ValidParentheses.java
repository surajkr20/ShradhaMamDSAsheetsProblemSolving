
// leetcode.ques.20. Valid Parentheses = https://leetcode.com/problems/valid-parentheses/description/

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s){
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }else{
                if(st.size() == 0) return false;
                if((st.peek() == '(' && ch == ')') || (st.peek() == '{' && ch == '}') || (st.peek() == '[' && ch == ']') ){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        if(st.size() > 0) return false;
        return true;
    }
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
}
