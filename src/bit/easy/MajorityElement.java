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
}
