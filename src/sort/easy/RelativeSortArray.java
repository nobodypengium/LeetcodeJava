package sort.easy;

import java.util.HashMap;
import java.util.Map;

/*注意学习快排*/
public class RelativeSortArray {
    Map<Integer,Integer> record; //用于检索arr2里谁靠前
    // 计数排序，由于给定数组值得范围，先将arr1存到一个给定长度的数组index中
    // 然后根据arr2作为index去检索，最后从前往后遍历index，剩下的就从小到大排序了
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] index = new int[1001];
        for (int i : arr1)
            index[i]++;
        int cnt = 0;
        for (int i : arr2)
            while (index[i]-- > 0)
                arr1[cnt++] = i;
        for (int i = 0; i < index.length; i++) {
            while (index[i]-- > 0)
                arr1[cnt++] = i;
        }
        return arr1;
    }

    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        record = new HashMap<>();
        for(int i=0;i<arr2.length;i++)
            record.put(arr2[i],i);
        quickSort(arr1,0,arr1.length-1);
        return arr1;
    }
    // 快速排序：直接在数组中原地修改
    public void quickSort(int[] arr,int lo,int hi){
        if(lo>=hi) return; //终止条件
        int p = arr[lo];
        int i = lo,j=hi;
        while(i<j){
            for(;j>i&&less(p,arr[j]);j--);
            for(;i<j&&less(arr[i],p);i++);
            if(i<j)
                swap(arr,i,j);
        }
        swap(arr,lo,j);
        quickSort(arr,lo,j-1);
        quickSort(arr,j+1,hi);
    }

    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }

    // 如果用基本的排序方法，比如快排，归并等，需要重新定义“小”，即在arr2中靠前，查询操作可以通过hashmap实现
    public boolean less(int num1,int num2){
        if(record.containsKey(num1)&&record.containsKey(num2))
            return record.get(num1)<=record.get(num2);
        else if(record.containsKey(num1))
            return true;
        else if(record.containsKey(num2))
            return false;
        else
            return num1<=num2;
    }
}
