package stack.easy;

import java.util.HashMap;
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

    public static boolean isValid_v1(String s){
        boolean isValid=true;
        if(s.isEmpty()){
            return isValid;
        }
        Stack<Character> stack = new Stack<Character>();
        for(char c:s.toCharArray()){
            switch (c){
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '(':
                    stack.push(')');
                    break;
                default:
                    if(stack.isEmpty()||stack.pop()!=c)
                        isValid=false;
                    break;
            }
        }

        return (isValid&&stack.empty());
    }

    public static boolean isValid_v2(String s){
//        较优解决方式：需要的数据结构：栈（暂存左括号）、map（确认左右括号）
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character,Character> map = new HashMap<Character, Character>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
        for(Character c:s.toCharArray()){
//            如果进来的是右括号，则如果栈空返回false，如果栈不空验证栈中第一个元素
            if(map.containsKey(c)){
                char top = stack.empty()?'#':stack.pop();
                if(top!=map.get(c))
                    return false;
            }else{
                //            如果进来的是左括号，则入栈
                stack.push(c);
            }
        }
        return stack.empty();
    }

//    较差解决方案，不断替换串中的匹配括号，直到串空（对了）或串长度不变（错了）
    public static boolean isValid_v3(String s){
        while(true){
            int length = s.length();
            s = s.replace("()","");
            s = s.replace("[]","");
            s = s.replace("{}","");
            if(length == s.length())
                break;
        }
        return s.isEmpty();
    }
}
