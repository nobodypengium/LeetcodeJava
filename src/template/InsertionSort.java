package template;

public class InsertionSort {
    public void insertionSort(int[] arr){
        // 从前往后选定值，向前遍历所有，遇到比他大的，则向后移位让空
        // 最后会在第一个比它小和第一个比它大的中间留出一个空，插入这个空
        for(int i=1;i<arr.length;i++){
            int j=i-1;
            int insertion=arr[i]; //使用insertion确保插入过程中如果i-1位移到i位影响判断
            for(;j>=0&&arr[j]>insertion;j--){
                arr[j+1]=arr[j];
            }
            arr[j+1]=insertion;
        }
    }
}
