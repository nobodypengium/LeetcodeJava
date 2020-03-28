package stack.easy;

import java.util.PriorityQueue;

public class KthLargest {
    // 手写小顶堆O(N)
//    private int count;
//    private int[] minheap;
//    private int len;
//    public KthLargest(int k, int[] nums) {
//        count = 0;
//        len=k+1;
//        minheap = new int[k+1];
//        for(int i:nums){
//            insert(i);
//        }
//    }
//
//    private void insert(int val){
//        if(count<len-1){
//            count++;
//            minheap[count] = val;
//            int i=count;
//            int prv = i/2;
//            //上浮
//            while(prv>0){
//                if(minheap[i]<minheap[prv]){
//                    swap(i,prv);
//                    i=prv;
//                    prv=i/2;
//                }else{
//                    break;
//                }
//            }
//        }else if(minheap[1]<val){
//            int i=1;
//            int maxpos = i;
//            minheap[i]=val;
//            //下潜
//            while(true){
//                if(i*2<len&&minheap[i*2]<minheap[maxpos]) //由于不一定是完全二叉树，所以每次判断左右分支时需要判断是否越界
//                    maxpos=i*2;
//                if(i*2+1<len&&minheap[i*2+1]<minheap[maxpos])
//                    maxpos=i*2+1;
//                if(maxpos==i)
//                    break;
//                swap(maxpos,i);
//                i=maxpos;
//            }
//        }
//    }
//
//    private void swap(int i,int j){
//        int tmp = minheap[j];
//        minheap[j]=minheap[i];
//        minheap[i]=tmp;
//    }
//
//    public int add(int val) {
//        insert(val);
//        return minheap[1];
//    }
    // 用PriorityQueue，顶上一定是最小元素，每次往外取对之后的元素进行排序
    PriorityQueue<Integer> priorityQueue;
    int len;
    int count;
    public KthLargest(int k, int[] nums) {
        priorityQueue = new PriorityQueue<>();
        len = k;
        count = 0;
        for(int i:nums){
            add(i);
        }
    }

    public int add(int val) {
        if(count<len){
            priorityQueue.offer(val);
            count++;
        }else{
            if(val>priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.offer(val);
            }
        }
        return priorityQueue.peek();
    }
}
