package sort.easy;

import template.InsertionSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SortIntegersbyTheNumberof1Bits {
    public int[] sortByBits(int[] arr) {
        for(int i=0;i<arr.length;i++){
            arr[i]=arr[i]+Integer.bitCount(arr[i])*100000;
        }
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            arr[i]=arr[i]%100000;
        }
        return arr;
    }
    public int[] sortByBits2(int[] arr){
        Arrays.sort(arr);
        return arr;
    }
    public int myCountBit(int num){
        int count=0;
        while(num>0){
            count++;
            num=num&(num-1);
        }
        return count;
    }
}
