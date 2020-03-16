package stack.easy;

import java.util.Stack;

public class BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int ans=0;
        for (String str : ops) {
            if (str.equals("+")) {
                int last = stack.pop();
                int now = last + stack.peek();
                stack.push(last);
                stack.push(now);
            } else if (str.equals("D")) {
                int now = stack.peek()*2;
                stack.push(now);
            } else if (str.equals("C")){
                stack.pop();
            } else{
                int now = Integer.parseInt(str);
                stack.push(now);
            }
        }
        for(int i:stack)
            ans = ans+i;
        return ans;
    }
}
