package greedy.easy;

public class DeleteColumnstoMakeSorted {
    public int minDeletionSize(String[] A) {
        if(A[0].length()==0||A.length<=1)
            return 0;
        int delate_num=0;
        for(int i=0;i<A[0].length();i++){
            for(int j=0;j<A.length-1;j++){
                if(A[j].charAt(i)>A[j+1].charAt(i)){
                    delate_num++;
                    break;
                }
            }
        }
        return delate_num;
    }
}
