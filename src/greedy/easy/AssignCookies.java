package greedy.easy;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        if(g.length==0||s.length==0)
            return 0; // 边界，没有孩子和饼干，所以一个孩子也不能满足
        Arrays.sort(g); // 先排序，再分配
        Arrays.sort(s);
        int max = 0;
        for(int i=0,j=0;i<s.length&&j<g.length;i++){ // 对每个最小的饼干，给最小的孩子，尽量保证每个饼干都分出去
            if(s[i]>=g[j]){
                max++;
                j++; //这个孩子已经得到满足了
            }
        }
        return max;
    }
}
