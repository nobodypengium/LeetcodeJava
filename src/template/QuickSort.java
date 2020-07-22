package template;

public class QuickSort {
    public int[] api(int[] arr){
        quickSort(arr,0,arr.length-1);
        return arr;
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
        return num1<=num2;
    }
}
