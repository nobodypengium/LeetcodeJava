package greedy.easy;

public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        return cal(prices,0);
    }
    public int cal(int[] prices, int start){
        if(start>=prices.length) // 保留到只剩最后一天
            return 0;
        int max = 0;
        for(int i=start;i<prices.length;i++){ // 遍历入手时刻
            int max_inner = 0; // 最后保存最佳出入手时刻所得结果
            for(int j=i+1;j<prices.length;j++){ // 遍历出手时刻
                if(prices[i]<prices[j]){
                    int price = cal(prices,j+1) + prices[j]-prices[i]; // 之后交易产生的最佳利润，和这次交易的利润之和
                    if(price>max_inner)
                        max_inner=price; // 因为出手时刻的不同决定的利润
                }
            }
            if(max_inner>max)
                max=max_inner;// 因为入手时刻的不同决定的利润
        }
        return max;
    }
}
