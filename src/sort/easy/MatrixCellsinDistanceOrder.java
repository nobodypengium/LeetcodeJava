package sort.easy;

import java.util.*;

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
    //还是返回一个[R*C][2]的二维数组，但是是直接调用快排，快排可以放Comparator进去来指定比较的方法，这样就不限于能比较一维数组，也能比较二维数组了
    public int[][] allCellsDistOrder2(int R, int C, int r0, int c0) {
        // 导入二维数组
        int[][] result = new int[R*C][2];
        int count = 0;
        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++) {
                result[count][0]=r;
                result[count][1]=c;
                count++;
            }
        }
        // 由Comparator定义
        Arrays.sort(result, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int dist1 = Math.abs(r0-o1[0])+Math.abs(c0-o1[1]);
                int dist2 = Math.abs(c0-o2[0])+Math.abs(c0-o2[1]);
                return dist1-dist2;
            }
        });
        return result;
    }
    //使用桶排序（实际上没有排序），每个桶里放同样dist的点，最后遍历所有桶。
    public int[][] allCellsDistOrder3(int R, int C, int r0, int c0) {
        // 导入二维数组
        int[][] result = new int[R*C][2];
        //找出桶间隔，本题中每个距离都有一个桶，实际上可以根据数据中的最大最小值再行计算
        int maxDist = Math.max(R-r0-1,r0)+Math.max(C-c0-1,c0);
        ArrayList<LinkedList<Pos>> buckets = new ArrayList<>(maxDist+1);//ArrayList理解为数组，这么做相当于对象数组
        //注意ArrayList的操作，刚创建好只是一个空数组，东西还得一个个往里放，比如linked list
        for(int i=0;i<maxDist+1;i++)
            buckets.add(new LinkedList<>());
        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                int dist = Math.abs(r-r0)+Math.abs(c-c0);
                Pos pos = new Pos(r,c);
                buckets.get(dist).add(pos);//接到对应桶的LinkedList
            }
        }

        // 顺序遍历所有桶，输出每个桶中的所有东西
        int count=0;
        for(int i=0;i<maxDist+1;i++){
            LinkedList<Pos> bucket = buckets.get(i);
            Iterator<Pos> it = bucket.iterator();
            while(it.hasNext()){
                Pos p = it.next();
                result[count][0]=p.r;
                result[count][1]=p.c;
                count++;
            }
        }

        return result;
    }

    private static class Pos{
        int r;
        int c;
        Pos(int r,int c){
            this.r=r;
            this.c=c;
        }
    }

    public int[][] allCellsDistOrder4(int R, int C, int r0, int c0) {
        int[][] result = new int[R*C][2];
        int cnt = 0; //记录已经填入数组的点的数量，作为循环终止条件
        int[] factor = new int[]{1,-1};
        int dist = 0; //遍历每种距离，并找寻这种距离下的所有点，将dist分配给col加的和row加的
        while(cnt<R*C){
            for(int toCol=0;toCol<=dist;toCol++){ //将dist首先全部给col，然后渐渐分配给row
                for(int i=0;i<2;i++){
                    int c = c0 + factor[i]*toCol;
                    for(int j=0;j<2;j++){
                        int r = r0 + factor[j]*(dist-toCol);
                        if(c>=0&&r>=0&&c<C&&r<R){
                            result[cnt][0]=r;
                            result[cnt][1]=c;
                            cnt++;
                        }
                        //终止条件，四个顶点只能添加进一次数组
                        if(factor[j]*(dist-toCol)==0)
                            break;
                    }
                    if(factor[i]*toCol==0)
                        break; //终止条件，四个顶点只能添加进一次数组
                }
            }
            dist++;
        }
        return result;
    }
}
