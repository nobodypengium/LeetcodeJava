package greedy.easy;

public class BestTimetoBuyandSellStockII {
    // 暴力法：采用递归思想。有一个函数要求最大利润。一次买入卖出的最大利润可以遍历买入时间（外层循环）和卖出时间（内层循环）。计算利润的方式为本次买入卖出所得利润和之后操作的最大利润。这就是递归。
    public int maxProfit(int[] prices) {
        return cal(prices, 0);
    }

    public int cal(int[] prices, int start) {
        if (start >= prices.length) // 保留到只剩最后一天
            return 0;
        int max = 0;
        for (int i = start; i < prices.length; i++) { // 遍历入手时刻
            int max_inner = 0; // 最后保存最佳出入手时刻所得结果
            for (int j = i + 1; j < prices.length; j++) { // 遍历出手时刻
                if (prices[i] < prices[j]) {
                    int price = cal(prices, j + 1) + prices[j] - prices[i]; // 之后交易产生的最佳利润，和这次交易的利润之和
                    if (price > max_inner)
                        max_inner = price; // 因为出手时刻的不同决定的利润
                }
            }
            if (max_inner > max)
                max = max_inner;// 因为入手时刻的不同决定的利润
        }
        return max;
    }

    // 峰谷法：画图，卖出时一定是紧接着一个谷的下一个峰
    public int maxProfit1(int[] prices){
        if(prices.length<=1)
            return 0;
        int valley = prices[0];
        int peek = prices[0];
        int max = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>peek) // 遇到更高的，将【峰】标记为更高的值，这样就可以与原来谷的位置做差了
                peek=prices[i];
            else{ // 每次一遇到下降就把之前累加的峰谷清算，并标记峰谷为新的位置
                max+=peek-valley;
                valley=prices[i];
                peek=prices[i];
            }
        }
        max+=peek-valley;// 避免连续上升并没有遇到下降的情况，存在未加上的利润
        return max;
    }

    // 总最大利润等于所有上升段的和，也就是每次涨我都买了。
    public int maxProfit2(int[] prices){
        if(prices.length<=1)
            return 0;
        int max=0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i+1]>prices[i])
                max+=prices[i+1]-prices[i];
        }
        return max;
    }
}
