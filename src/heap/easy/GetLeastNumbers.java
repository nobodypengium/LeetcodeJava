/**
 * 面试题40. 最小的k个数
 */

package heap.easy;

import java.util.*;

public class GetLeastNumbers {
    /**长度为k的最大堆，每次跟堆内最大值（顶点）相比，如果比顶点小就把新的数放进去替换掉顶点**/
//    public int[] getLeastNumbers(int[] arr, int k) {
//        if(k==0)
//            return new int [0];
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>(){
//            @Override
//            public int compare(Integer integer,Integer t1){
//                return t1-integer;
//            }
//        });
//        for(int i=0;i<arr.length;i++){
//            if(i<k)
//                priorityQueue.add(arr[i]);
//            else if(arr[i]<priorityQueue.peek()){
//                priorityQueue.poll();
//                priorityQueue.add(arr[i]);
//            }
//        }
//
//        int[] ans = new int[k];
//        Object[] objarr = priorityQueue.toArray();
//        for(int i=0;i<k;i++)
//            ans[i]=(Integer) objarr[i];
//
//        return ans;
//    }
    /**基于快排变形，要写快排，首先得把每次移动hi,lo的基本模块写完，然后写迭代。**/
//    public int[] getLeastNumbers(int[] arr, int k) {
//        if(k==0||arr.length==0)
//            return new int[0];
//        quickSort(arr,arr.length-1,0,k-1);
//        int[] result = Arrays.copyOfRange(arr,0,k);
//        return result;
//    }
//    // 花式快排的迭代器
//    private void quickSort(int[] arr,int hi,int lo,int k){
//        // 终止条件，我们只要找到分界点和分界点一侧的值即可，并不需要完整排序，**根据pivot位置和前k个数的k的相对位置关系决定
//        // 从哪开始执行partition**
//        int mid = partition(arr,hi,lo);
//        if(mid==k)
//            return;
//        else if(mid<k)
//            quickSort(arr,hi,mid+1,k);
//        else if(mid>k)
//            quickSort(arr,mid-1,lo,k);
//    }
//
//    // 快排基本模块，在给定区间中，将不同小于pivot的值分在pivot左边，大于pivot的值分在pivot右边
//    private int partition(int[] arr,int hi,int lo){
//        int i = lo;
//        int j = hi+1;
//        int pivot = arr[i];
//        while(i<j){
//            while(--j>i&&arr[j]>pivot);
//            arr[i]=arr[j];
//            if(i==j)
//                break;
//            while(++i<j&&arr[i]<pivot);
//            arr[j]=arr[i];
//        }
//        arr[i]=pivot;
//        return i;
//    }
    /**基于红黑树TreeMap，可以获得有序输出**/
//    public int[] getLeastNumbers(int[] arr, int k) {
//        if(k==0||arr.length==0)
//            return new int[0];
//        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
//        int count=0;
//        for(int val:arr){
//            if(count<k)
//                treeMap.put(val,treeMap.getOrDefault(val,0)+1);
//            else if(val<treeMap.lastKey()){
//                if(treeMap.lastEntry().getValue()==1)
//                    treeMap.pollLastEntry();
//                else
//                    treeMap.put(treeMap.lastKey(),treeMap.lastEntry().getValue()-1);
//                treeMap.put(val,treeMap.getOrDefault(val,0)+1);
//            }
//            count++;
//        }
//        int ans[] = new int[k];
//        int ansidx=0;
//        for(Map.Entry<Integer,Integer> entry:treeMap.entrySet()){
//            for(int i=0;i<entry.getValue();i++,ansidx++){
//                ans[ansidx]=entry.getKey();
//            }
//        }
//        return ans;
//    }
    /**输入数据有范围的话，直接计数排序，i.e.创建跟数据范围等大的数组，然后每遇到一个数再对应索引的位置+1，最后从前往后数k个**/
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 统计每个数字出现的次数
        int[] counter = new int[10001];
        for (int num: arr) {
            counter[num]++;
        }
        // 根据counter数组从头找出k个数作为返回结果
        int[] res = new int[k];
        int idx = 0;
        for (int num = 0; num < counter.length; num++) {
            while (counter[num]-- > 0 && idx < k) {
                res[idx++] = num;
            }
            if (idx == k) {
                break;
            }
        }
        return res;
    }
}