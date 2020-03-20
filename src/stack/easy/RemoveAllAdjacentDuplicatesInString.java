package stack.easy;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    // 使用一个栈，当有重复的时候弹出，但是慢！
//    public String removeDuplicates(String S) {
//        Stack<Character> stack = new Stack();
//        String ans = "";
//        for(Character c:S.toCharArray()){
//            if(!stack.isEmpty()&&stack.peek()==c)
//                stack.pop();
//            else
//                stack.push(c);
//        }
//        while(!stack.isEmpty()){
//            ans = stack.pop() + ans;
//        }
//        return ans;
//    }
    // 还是栈的原理，但是用数组实现，快。建立一个指针，遇到相同的两个字母指针回退两格。
    // 当指针后移的时候更新指针所处位置为数组内新的元素。
    public String removeDuplicates(String S) {
        int i = 0;
        char[] res = S.toCharArray();
        for(int j = 0;j < res.length; j++,i++){
            res[i] = res[j];
            if(i>0 && res[i]==res[i-1]){
                i -= 2;
            }
        }
        return new String(res, 0, i);
    }
}
