package stack.easy;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s){
        boolean isValid=true;
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length()&&isValid==true;i++){
            char now = s.charAt(i);
            switch (now){
                case '{':
                    stack.push(now);
                    break;
                case '(':
                    stack.push(now);
                    break;
                case '[':
                    stack.push(now);
                    break;
                case '}':
                    if(stack.empty()||stack.peek()!='{')
                        isValid=false;
                    else
                        stack.pop();
                    break;
                case ')':
                    if(stack.empty()||stack.peek()!='(')
                        isValid=false;
                    else
                        stack.pop();
                    break;
                case ']':
                    if(stack.empty()||stack.peek()!='[')
                        isValid=false;
                    else
                        stack.pop();
                    break;
                default:
                    break;
            }
        }
        if(!stack.empty()){
            isValid=false;
        }
    return isValid;
    }
}
