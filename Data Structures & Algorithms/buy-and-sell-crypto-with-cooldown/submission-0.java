class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return profit(prices, n, 0, 1, dp);
    }

    private int profit(int[] prices, int n, int i, int canBuy, int[][] dp){
        if(i>=n) return 0;
        if(dp[i][canBuy] != -1) return dp[i][canBuy];

        if(canBuy==1){
            int buy = -prices[i] + profit(prices, n, i+1, 0, dp);
            int noBuy = profit(prices, n, i+1, 1, dp);
            return dp[i][canBuy] = Math.max(buy, noBuy);
        }else{
            int sell = prices[i] + profit(prices, n, i+2, 1, dp);
            int noSell = profit(prices, n, i+1, 0, dp);
            return dp[i][canBuy] = Math.max(sell, noSell);
        }
    }
}
