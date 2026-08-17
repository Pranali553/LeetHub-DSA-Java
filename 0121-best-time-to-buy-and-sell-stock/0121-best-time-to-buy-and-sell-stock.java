class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int mini = prices[0];
        int maxprofit = 0;

        for(int i = 1; i < n; i++){
            int profit = prices[i] - mini;
            maxprofit = Math.max(maxprofit, profit);
            mini = Math.min(mini, prices[i]);
        }
        return maxprofit;
    }
}
       

