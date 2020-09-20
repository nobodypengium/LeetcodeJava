package bit.easy;

import java.util.*;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i=i+2){
            if(i==nums.length-1||nums[i]!=nums[i+1])
                return nums[i];
        }
        return 0;
    }
    public int singleNumber2(int[] nums){
        // 使用集合，哈希表登
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            if(set.contains(i)){
                set.remove(i);
            }else{
                set.add(i);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        return list.get(0);
    }
    public int singleNumber3(int[] nums) {
        //力荐！使用亦或运算的特性节约空间，1.两个相同的数异或得0，2.异或得结合律，把数组所有数异或了，剩的就是单个的
        for(int i=1;i<nums.length;i++)
            nums[0]^=nums[i];
        return nums[0];
    }
}
