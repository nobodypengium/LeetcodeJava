package sort.easy;

public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int[] oddArray = new int[A.length/2];
        int[] evenArray = new int[A.length/2];
        for(int i=0,oddi=0,eveni=0;i<A.length;i++){
            if(A[i]%2==0)
                evenArray[eveni++]=A[i];
            else
                oddArray[oddi++]=A[i];
        }
        for(int i=0;i<A.length;i++){
            if(i%2==0)
                A[i]=evenArray[i/2];
            else
                A[i]=oddArray[i/2];
        }
        return A;
    }
    public int[] sortArrayByParityII1(int[] A) {
        int[] resultArr = new int[A.length];
        int idx=0;
        for(int i:A){
            if(i%2==0) {
                resultArr[idx] = i;
                idx = idx + 2;
            }
        }
        idx = 1;
        for(int i:A){
            if(i%2!=0){
                resultArr[idx] = i;
                idx = idx + 2;
            }
        }
        return resultArr;
    }
    public int[] sortArrayByParityII2(int[] A) {
        for(int i=0,j=1;i<A.length&&j<A.length;){
            while(i<A.length&&A[i]%2==0)
                i+=2;
            while(j<A.length&&A[j]%2!=0)
                j+=2;
            if(i<A.length&&j<A.length){
                int tmp = A[i];
                A[i]=A[j];
                A[j]=tmp;
            }
        }
        return A;
    }
}
