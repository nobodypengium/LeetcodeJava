package sort.easy;

public class MatrixCellsinDistanceOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] result = new int[R*C][2];
        result[0][0]=r0;
        result[0][1]=c0;
        int left=c0,right=c0,top=r0,bottom=r0;
        int count=1; //出过错，因为已经填进去一个了，所以这里起始为1
        while(count<R*C){
            left--; //出过错，注意移动方向
            right++;
            top++;
            bottom--;
            //四个端点
            if(left>=0){
                result[count][0]=r0;
                result[count][1]=left;
                count++;
            }
            if(right<C){
                result[count][0]=r0;
                result[count][1]=right;
                count++;
            }
            if(bottom>=0){
                result[count][0]=bottom;
                result[count][1]=c0;
                count++;
            }
            if(top<R){
                result[count][0]=top;
                result[count][1]=c0;
                count++;
            }
            //从左到右遍历
            for(int c=left+1,r=r0+1;r<R||(2*r0-r)>=0||(c>=0&&c<c0)||((2*c0-c)<C&&(2*c0-c)>c0);c++,r++){ //上下左右四边都超边界的时候终止
                //左上
                if(c>=0&&c<c0&&r<R&&r>r0){
                    result[count][0]=r;
                    result[count][1]=c;
                    count++;
                }
                //右上
                if((2*c0-c)<C&&(2*c0-c)>c0&&r<R&&r>r0){
                    result[count][0]=r;
                    result[count][1]=2*c0-c;
                    count++;
                }
                //右下
                if((2*c0-c)<C&&(2*c0-c)>c0&&(2*r0-r)>=0&&(2*r0-r)<r0){
                    result[count][0]=2*r0-r;
                    result[count][1]=2*c0-c;
                    count++;
                }
                //左下
                if(c>=0&&c<c0&&(2*r0-r)>=0&&(2*r0-r)<r0){
                    result[count][0]=2*r0-r;
                    result[count][1]=c;
                    count++;
                }
            }
        }
        return result;
    }
}
