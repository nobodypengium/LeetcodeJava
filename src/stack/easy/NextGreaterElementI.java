package stack.easy;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {
////    暴力法解决，创建一个数组全部填为-1，暴力搜索如果有比它大的再它后面，填新值回去。flat用于判断是否找到了目前基准值。
//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        int[] ans = new int[nums1.length];
//        boolean flag = false;
//
//        for(int i=0;i<nums1.length;i++){
//            ans[i]=-1;
//            flag=false;
//            for(int j=0;j<nums2.length;j++){
//                if(flag&&nums2[j]>nums1[i]){
//                    ans[i]=nums2[j];
//                    break;
//                }
//                if(nums1[i]==nums2[j])
//                    flag=true;
//            }
//        }
//        return ans;
//    }
//
//    这并不是最优解法，看下一个解法。缺点1：没有理解单调栈，单调栈应该是只要小就推进去。缺点2：多调用了检查map是否含有key的方法，最好直接再map用一个循环提前赋值好-1
public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Stack<Integer> stack = new Stack<>();
    HashMap<Integer,Integer> map = new HashMap<>();
    for(int i=0;i<nums2.length;i++){
        if(stack.isEmpty()||stack.peek()>nums2[i]){
            stack.push(nums2[i]);
        }else{
            while(!stack.isEmpty()){
                int top = stack.pop();
                if(nums2[i]>top)
                    map.put(top,nums2[i]);
                else{
                    stack.push(top);
                    break;
                }
            }
            stack.push(nums2[i]);
        }
    }

    int[] ans = new int[nums1.length];
    for(int i=0;i<nums1.length;i++){
        if(map.containsKey(nums1[i]))
            ans[i] = map.get(nums1[i]);
        else
            ans[i]=-1;
    }
    return ans;
}

}
