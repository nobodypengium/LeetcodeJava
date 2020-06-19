package greedy.easy;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        int mincost = 0; // 最低费用
        Arrays.sort(costs,new Comparator<int[]>(){ //假设所有人都去A，然后排序让改去B费用少的去B，最后排完了前面10个去B
            @Override
            public int compare(int[] o1, int[] o2){
                return (o1[1]-o1[0])-(o2[1]-o2[0]); //假设所有人最开始都去A地，每两个间改去B地所需费用排序
            }
        });
        for(int i=0;i<costs.length/2;i++)
            mincost+=costs[i][1];
        for(int i=costs.length/2;i<costs.length;i++)
            mincost+=costs[i][0];
        return mincost;
    }
}
