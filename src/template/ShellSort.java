package template;

public class ShellSort {
    public void shellSort(int[] arr){
        int gap;
        for(gap=arr.length/2;gap>0;gap/=2){
            // gap从初始一半逐渐到1，就退化成插入排序
            for(int i=gap;i<arr.length;i++){
                // 针对差值gap执行插入排序，也就是往前找地方把gap及其之后位置的数分组插入
                insertion(arr,gap,i);
            }
        }
    }
    private void insertion(int[] arr,int gap,int i){
        // 实现向前找空插入
        int j;
        int insertion = arr[i];
        for(j=i-gap;j>=0&&arr[j]>insertion;j=j-gap){
            arr[j+gap]=arr[j];
        }
        arr[j+gap]=insertion;
    }
}
