package stack.easy;

import java.util.Stack;

public class BackspaceStringCompare {
//    public boolean backspaceCompare(String S, String T) {
//        Stack<Character> stackS = new Stack<>();
//        Stack<Character> stackT = new Stack<>();
//        boolean ans = true;
//        for(int i=0;i<S.length();i++){
//            if(S.charAt(i)=='#'){
//                if(!stackS.isEmpty())
//                    stackS.pop();
//            }else{
//                stackS.push(S.charAt(i));
//            }
//        }
//        for(int i=0;i<T.length();i++){
//            if(T.charAt(i)=='#'){
//                if(!stackT.isEmpty())
//                    stackT.pop();
//            }else{
//                stackT.push(T.charAt(i));
//            }
//        }
//        System.out.println(stackS.toString());
//        while(!stackS.isEmpty()){
//            if(stackT.isEmpty()||stackS.pop()!=stackT.pop())
//                ans=false;
//            break;
//        }
//        return ans;
//    }
    public boolean backspaceCompare(String S, String T) {
        int i=S.length()-1,j=T.length()-1;
        int skipi=0,skipj=0;
        while(i>=0||j>=0){
            while(i>=0){
                if(S.charAt(i)=='#'){
                    skipi++;i--;
                }else if(skipi>0){
                    skipi--;i--;
                }else{
                    break;
                }

            }
            while(j>=0){
                if(T.charAt(j)=='#'){
                    skipj++;j--;
                }else if(skipi>0){
                    skipj--;j--;
                }else{
                    break;
                }
            }
            if((i>=0)!=(j>=0))
                return false;
            if(i>=0&&j>=0&&S.charAt(i)!=T.charAt(j))
                return false;
            i--;j--;
        }
        return true;
    }
}
