package sort.easy;

import java.util.Arrays;

public class CanMakeArithmeticProgressionFromSequence {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int[] aux = new int[2*1000000+1];
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE,interval=Integer.MAX_VALUE;
        int pivot = (int)(2*1000000+1)/2;
        for(int i:arr){
            if(Math.abs(i-min)<interval) //计算间隔类题目要么提前计算好，要么需要反复取间隔最小值
                interval=Math.abs(i-min);
            if(i<min)
                min=i;
            if(i>max)
                max=i;
            if((min!=max)&&(aux[pivot+i]!=0)) //特殊情况的考虑，是否数组中全是一个数，如果全是一个数可能导致d=0时某个位置有好多个是合理的
                return false;
            aux[pivot+i]++;
        }
        for(int i=pivot+min+interval,count=0;count<(arr.length)&&i<aux.length;i=i+interval){
            if(i-interval<0||aux[i-interval]<1) //已知首项和间隔，从前往后找，如果某个位置没有数，那就gg
                return false;
            count++;
        }
        return true;
    }
    public boolean canMakeArithmeticProgression1(int[] arr) {
        Arrays.sort(arr);
        int interval =arr[1]-arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]!=interval)
                return false;
        }
        return true;
    }
}
