package sort.easy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        for(int i:nums1)
            hashSet.add(i);
        for(int i:nums2)
            if(hashSet.contains(i))
                resultSet.add(i);

        int[] resultArr = new int[resultSet.size()];
        Iterator<Integer> it = resultSet.iterator();
        for(int i=0;it.hasNext();i++)
            resultArr[i]=it.next();

        return resultArr;
    }

    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> hashSet1 = new HashSet<>();
        Set<Integer> hashSet2 = new HashSet<>();
        for(int i:nums1)
            hashSet1.add(i);
        for(int i:nums2)
            hashSet2.add(i);

        hashSet1.retainAll(hashSet2);
        int[] resultArr = new int[hashSet1.size()];
        int idx=0;
        for(int i:hashSet1)
            resultArr[idx++]=i;

        return resultArr;
    }

}
