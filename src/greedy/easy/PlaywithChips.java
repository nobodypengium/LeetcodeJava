package greedy.easy;

public class PlaywithChips {
    public int minCostToMoveChips(int[] chips) {
        int mincost=Integer.MAX_VALUE;
        for(int i=0;i<chips.length;i++){
            int cost=0;
            for(int j=0;j<chips.length;j++){
                cost+=Math.abs((chips[i]-chips[j]))%2;
            }
            if(cost<mincost)
                mincost=cost;
        }
        return mincost;
    }
    //统计奇数偶数的个数，奇数移到奇数不需要代价，偶数移到偶数不需要代价，互相之间移动需要代价
    //也要关注到这个题实际上只有1和0两种代价的特殊性
    public int minCostToMoveChips1(int[] chips){
        int mincost=Integer.MAX_VALUE;
        int odd=0,even=0;
        for(int i=0;i<chips.length;i++){
            if(chips[i]%2==0)
                even++;
            else
                odd++;
        }
        return Math.min(odd,even);
    }
}
