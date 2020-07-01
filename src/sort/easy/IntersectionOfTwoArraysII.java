package sort.easy;

import java.lang.reflect.Array;
import java.util.*;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> hashMap = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();
        for(int i:nums1)
            hashMap.put(i,hashMap.getOrDefault(i,0)+1);
        for(int i:nums2){
            if(hashMap.containsKey(i)){
                hashMap.put(i,hashMap.get(i)-1);
                resultList.add(i);
                if(hashMap.get(i)==0)
                    hashMap.remove(i);
            }
        }

        int[] resultArray = new int[resultList.size()];
        Iterator<Integer> it = resultList.iterator();
        int idx=0;
        while(it.hasNext())
            resultArray[idx++]=it.next();

        return resultArray;
    }
    public int[] intersect1(int[] nums1, int[] nums2) {
        List<Integer> resultList = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]<nums2[j])
                i++;
            if(!(i<nums1.length&&j<nums2.length))
                break;;
            if(nums2[j]<nums1[i])
                j++;
            if(!(i<nums1.length&&j<nums2.length))
                break;;
            if(nums1[i]==nums2[j]){
                resultList.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] resultArray = new int[resultList.size()];
        Iterator<Integer> it = resultList.iterator();
        int idx=0;
        while(it.hasNext())
            resultArray[idx++]=it.next();

        return resultArray;
    }
}
