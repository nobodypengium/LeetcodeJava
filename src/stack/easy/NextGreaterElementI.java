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
//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        Stack<Integer> stack = new Stack<>();
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int i=0;i<nums2.length;i++){
//            if(stack.isEmpty()||stack.peek()>nums2[i]){
//                stack.push(nums2[i]);
//            }else{
//                while(!stack.isEmpty()){
//                    int top = stack.pop();
//                    if(nums2[i]>top)
//                        map.put(top,nums2[i]);
//                    else{
//                        stack.push(top);
//                        break;
//                    }
//                }
//                stack.push(nums2[i]);
//            }
//        }
//
//        int[] ans = new int[nums1.length];
//        for(int i=0;i<nums1.length;i++){
//            if(map.containsKey(nums1[i]))
//                ans[i] = map.get(nums1[i]);
//            else
//                ans[i]=-1;
//        }
//        return ans;
//    }
//    // 使用单调栈，栈里一定保存从小到大的，且永远是最顶上与新来的比较，但是代码更精简
//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        Stack<Integer> stack = new Stack<>();
//        HashMap<Integer,Integer> map = new HashMap<>();
//        int[] ans = new int[nums1.length];
//        // 构造单调栈
//        for(int i=0;i<nums2.length;i++){
//            while(!stack.isEmpty()&&nums2[i]>stack.peek())//注意这里精简的写法，如果正着写会多一行判断
//                map.put(stack.pop(),nums2[i]);
//            stack.push(nums2[i]);
//        }
//        // 没有比它大的置-1（还在栈里的）
//        while(!stack.isEmpty())
//            map.put(stack.pop(),-1);
//        // 从键值对查询答案
//        for(int i=0;i<nums1.length;i++)
//            ans[i] = map.get(nums1[i]);
//        return ans;
//    }
    public int[] nextGreaterElement(int[] para1, int[] para2) {
        int[] result = new int[para1.length];
        if (para1.length == 0) {
            return result;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int p : para2) {
            if (p > max) {
                max = p;
            }
            if (p < min) {
                min = p;
            }
        }
        int[] index = new int[max + 1 - min];
        int last = para2[para2.length - 1];
        index[last - min] = -1;
        for (int i = para2.length - 2; i >= 0; i--) {
            int current = para2[i];
            int next = para2[i + 1];
            while (current > next && next != -1) {
                next = index[next - min];
            }
            index[current - min] = next;
        }
        for (int i = 0; i < para1.length; i++) {
            result[i] = index[para1[i] - min];
        }
        return result;
    }
}
