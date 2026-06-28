class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return ans(amount, coins, n-1, dp);
    }

    private int ans(int target, int[] coins, int i, int[][] dp){
        if(target==0 || (i==0 && target==coins[0])) return 1;
        if(i<0 || target<0) return 0;
        if(dp[i][target] != -1) return dp[i][target];

        int pick = ans(target-coins[i], coins, i, dp);
        int noPick = ans(target, coins, i-1, dp);

        return dp[i][target] = pick + noPick;
    }
}
