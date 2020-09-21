package bit.easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        // 遍历数组将所有元素放到hashmap中，遍历hashmap找到value > 1/2的，也就是说半数以上都是这个数
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            if(map.containsKey(i))
                map.put(i,map.get(i)+1);
            else
                map.put(i,1);
        }
        for(Integer key:map.keySet()){
            if(map.get(key)>(nums.length/2))
                return key;
        }
        return 0;
    }
    public int majorityElement2(int[] nums) {
        // 利用众数的性质，首先设置第一个数为众数，往后遍历，如果某个数跟他一样则计数器+1，否则-1，如果计数器为0换新的数，这样最后剩的就是众数
        int candidate = 0;
        for(int count=0,i=0;i<nums.length;i++){
            if(count==0)
                candidate=nums[i];
            if(candidate==nums[i]){
                count++;
            }else{
                count--;
            }
        }
        return candidate;
    }
    public int majorityElement3(int[] nums){
//        递归函数入口
        return majorityElementRec(nums,0,nums.length-1);
    }
    public int majorityElementRec(int[] nums,int lo, int hi){
        if(lo==hi) //终止条件
            return nums[lo];
        // 如果没有归并到最小块，逐渐弄到最小块，反复执行majorityElementRec
        int loMajority = majorityElementRec(nums,lo,lo+(hi-lo)/2);
        int hiMajority = majorityElementRec(nums,lo+(hi-lo)/2,hi);
        if(loMajority==hiMajority)
            return loMajority;
        else
            return countMajority(nums,loMajority,lo,hi)>countMajority(nums,hiMajority,lo,hi)?loMajority:hiMajority;
    }
    public int countMajority(int[] nums,int majority,int lo,int hi){
        int count=0;
        for(int i=lo;i<=hi;i++){
            if(nums[i]==majority)
                count++;
        }
        return count;
    }
}
