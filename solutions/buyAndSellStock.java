class Solution {
    public int maxProfit(int[] prices) {
        // max profit default variable
        int maxProfit = 0;
        // default minimum value
        int minBuy = prices[0];

        for (int sell : prices) {
            // compute new max if sell - minBuy exceeds current max
            maxProfit = Math.max(maxProfit, sell - minBuy);
            // compute new minimum if sell is lower than minimum
            minBuy = Math.min(minBuy, sell);
        }

        return maxProfit;
    }
}