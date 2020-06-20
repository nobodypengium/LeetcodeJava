package greedy.easy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] A, int K) {
        int sum=0;
        while(K--!=0){ // 必须要进行K次取反操作
            int KSum=Integer.MIN_VALUE;// 第K次操作时的最大和
            int choseni=0; // 能使进行这次取反操作后数组和最大的i，每次遍历完后更新choseni处数组值为相反数
            for(int i=0;i<A.length;i++){
                int tmpSum=0; // 存储每次移动时的求和值，如果求和值大于K次操作时的最大和，那么就选择这个i作为第K次操作的最终取反
                if(i==0){ // 每次向右移动一位变反
                    A[i]=-A[i];
                }else{
                    A[i-1]=-A[i-1];
                    A[i]=-A[i];
                }
                for(int j=0;j<A.length;j++){ //求和
                    tmpSum+=A[j];
                }
                if(tmpSum>KSum){// 存储每次移动时的求和值，如果求和值大于K次操作时的最大和，那么就选择这个i作为第K次操作的最终取反
                    KSum=tmpSum;
                    choseni=i;
                }
            }
            A[A.length-1]=-A[A.length-1]; // 把对数组的破坏恢复
            A[choseni]=-A[choseni];
            sum=KSum;
        }
        return sum;
    }
    //动动脑子，当对数组性质进行分析之后，发现这是一个排序再求解的问题
    //如果最小值是负数，那么直接对最小值取反
    //如果最小值是正数，也是对最小值取反
    public int largestSumAfterKNegations1(int[] A, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum=0;
        for(int i:A)
            pq.add(i);
        while(K--!=0)
            pq.add(-pq.poll());
        Iterator<Integer> iterator = pq.iterator();
        while (iterator.hasNext())
            sum+=iterator.next();
        return sum;
    }
    // 先排序
    // 先把负的全部变正
    // 再一直动大于0的最小数反复取反以最小限度影响已经变成最大的和
    public int largestSumAfterKNegations2(int[] A, int K) {
        Arrays.sort(A);
        int minIndex=0,sum=0;
        while(K-->0){
            A[minIndex]=-A[minIndex];
            if(minIndex<A.length&&A[minIndex]>A[minIndex+1])
                minIndex++;
        }
        for(int i:A)
            sum+=i;
        return sum;
    }
    // 计数排序版本可以避免高复杂度的排序操作，因为只要O(N)就可以相当于排序了
    public int largestSumAfterKNegations3(int[] A, int K) {
        int sum=0;
        int[] count = new int[201]; // -100<=A[i]<=100 必须平移，因为数组没有负索引
        for(int i:A){ //计数排序
            count[i+100]++;
        }
        // 先把负数全都变成正数
        // 如果是正数那就反复变最小的
        int minIndex=0;
        while(K-->0){
            while(count[minIndex]==0)//找到最小的数的位置
                minIndex++;
            count[minIndex]--; //找一个数
            count[200-minIndex]++; //给上一行找到的数变负
            if(minIndex>=100)
                minIndex=200-minIndex;
        }
        for(int i=0;i<count.length;i++)
            sum+=(i-100)*count[i];
        return sum;
    }

}
