package stack.easy;

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

}
