package stack.easy;

import java.util.HashMap;
import java.util.Stack;

public class RemoveOutermostParentheses {
    // 自己写的垃圾解
    // 使用三个栈，栈1存左括号（，栈2存右括号），栈3存所有的。当栈1栈2相等时意味着需要输出。
    // 输出时注意两点：1、注意最后一个和第一个不输出 2、注意不同原语间的隔离
//    public String removeOuterParentheses(String S) {
//        Stack<Character> stack1 = new Stack<>();
//        Stack<Character> stack2 = new Stack<>();
//        Stack<Character> stack3 = new Stack<>();
//        String ans = "";
//        for(Character c:S.toCharArray()){
//            if(c=='(')
//                stack1.push(c);
//            else{
//                stack2.push(c);
//            }
//            stack3.push(c);
//            if(stack1.size()==stack2.size()){
//                String tmpans="";
//                stack3.pop();
//                while(stack3.size()>1)
//                    tmpans = "" + stack3.pop() + tmpans;
//                stack3.pop();
//                ans = ans+tmpans;
//            }
//        }
//        return ans;
//    }
    // 使用StringBuilder，本质上顺序从左到右输出，但是添加一个计数器，在每个原语开始和结束的位置不输出。
    public String removeOuterParentheses(String S) {
        StringBuilder sb=new StringBuilder();
        int left=0;
        for(char ch:S.toCharArray()){
            if(ch=='('){
                if(left!=0) sb.append(ch);
                left++;
            }
            else{
                left--;
                if(left!=0) sb.append(ch);
            }
        }
        return sb.toString();
    }

}
