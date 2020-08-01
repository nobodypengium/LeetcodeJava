package template;

public class MergeSort {
    public void mergeSort(int[] arr){
        int[] result=new int[arr.length];
        for(int block=1;block<arr.length;block*=2){
            for(int start=0;start<arr.length;start=start+block*2){
                int low=start;
                int mid=start+block>arr.length?arr.length:start+block;
                int high=start+2*block>arr.length?arr.length:start+2*block;
                int start1=low,end1=mid;
                int start2=mid,end2=high;
                // 因为是从1个块大小开始逐渐排上来的，所以每个块内已经是有序的，只需要比较两个块最开始位置的数
                while(start1<end1&&start2<end2){
                    result[low++]=arr[start1]<arr[start2]?arr[start1++]:arr[start2++];
                }
                while(start1<end1){
                    result[low++]=arr[start1++];
                }
                while(start2<end2){
                    result[low++]=arr[start2++];
                }
            }
            // 不能简单的arr=result，否则这两个指向同一块地址，会同时变，这样第二次迭代就会因为修改了result内的元素而修改了arr内的元素，是错误的
            // 因此需要创建新空间，或交换地址，将arr的地址指向result，将result的地址指向别的地方
            int[] temp = arr;
            arr=result;
            result=temp;
        }
    }
    public void mergeSortRecursive(int[] arr,int[] result,int start, int end){
        //当block=1时返回
        if(start>=end-1)
            return;
        //左闭右开区间
        int low = start,mid=start+(end-start)/2,high=end;
        int start1=start,end1=mid;
        int start2=mid,end2=end;
        mergeSortRecursive(arr,result,start1,end1);
        mergeSortRecursive(arr,result,start2,end2);
        //两个block一定是有序的，只需检索每个block第一个元素比较放入result
        while(start1<end1&&start2<end2){
            result[low++]=arr[start1]<arr[start2]?arr[start1++]:arr[start2++];
        }
        while(start1<end1){
            result[low++]=arr[start1++];
        }
        while(start2<end2){
            result[low++]=arr[start2++];
        }
        //需要修改arr地址中得数组值，以备迭代回去能够访问到更新后得部分排序得数组值
        for(;start<end;start++)
            arr[start]=result[start];
    }
    public void mergeSortRecursiveAPI(int[] arr){
        int[] result = new int[arr.length];
        mergeSortRecursive(arr,result,0,arr.length);
    }

}
