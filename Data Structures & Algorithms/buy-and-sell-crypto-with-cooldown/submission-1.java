class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int i=n-1;i>=0;i--){
            for(int j=1; j>=0; j--){
                if(j==1){
                    int buy = -prices[i] + dp[i+1][0];
                    int noBuy = dp[i+1][1];
                    dp[i][j] = Math.max(buy, noBuy);
                }else {
                    int sell = (i + 2 < n) ? prices[i] + dp[i+2][1]
                    : prices[i];
                    int noSell = dp[i+1][0];
                    dp[i][j] = Math.max(sell, noSell);
                }
            }
        }
        return dp[0][1];
    }
}
