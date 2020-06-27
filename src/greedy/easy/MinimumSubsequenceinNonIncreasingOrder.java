package greedy.easy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSubsequenceinNonIncreasingOrder {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> integerList= new ArrayList<>();
        Arrays.sort(nums);
        int sum =0;
        int pre_sum=0;
        for(int i=0;i<nums.length;i++){
            sum +=nums[i];
        }
        for(int i=nums.length-1;i>=0;i--){
            pre_sum+=nums[i];
            integerList.add(nums[i]);
            if(pre_sum>sum/2)
                break;
        }
        return integerList;
    }
}
