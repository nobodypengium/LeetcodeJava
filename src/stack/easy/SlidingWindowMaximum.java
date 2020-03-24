package stack.easy;

import java.sql.Array;
import java.util.ArrayDeque;

public class SlidingWindowMaximum {
    //自己搞得暴力法，两层循环，外层遍历数组，内层遍历k
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if(nums.length==0)
//            return nums;
//        int[] res = new int[nums.length-k+1];
//        int max = Integer.MIN_VALUE;
//        for(int i=0;i<nums.length-k+1;i++){
//            max = Integer.MIN_VALUE;
//            for(int j=i;j<i+k;j++){
//                if(nums[j]>max)
//                    max = nums[j];
//            }
//            res[i]=max;
//        }
//        return res;
//    }
    ArrayDeque<Integer> deque = new ArrayDeque<>();
    int nums[];
    public void cleanQueue(int i,int k){
        if(!this.deque.isEmpty()&&this.deque.getFirst()<=i-k)
            deque.removeFirst();
        while(!deque.isEmpty()&&nums[i]>nums[deque.getLast()])
            deque.removeLast();
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length*k==0) return new int[0];
        if(nums.length==1) return nums;
        this.nums=nums;
        //初始化
        int max_index = 0;
        for(int i=0;i<k;i++){
            cleanQueue(i,k);
            this.deque.addLast(i);
            if(nums[i]>nums[max_index])
                max_index=i;
        }
        int[] output = new int[nums.length-k+1];
        output[0]=nums[max_index];
        for(int i=k;i<nums.length;i++){
            cleanQueue(i,k);
            this.deque.addLast(i);
            output[i-k+1]=nums[deque.getFirst()];
        }
        return output;
    }
}
