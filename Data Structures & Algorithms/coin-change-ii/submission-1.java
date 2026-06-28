class Solution {
    public int change(int target, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[coins.length+1][target+1];
        for(int i=0;i<coins.length;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<=coins.length;i++){
            for(int j=0;j<=target;j++){
                int pick = j>=coins[i-1] ? dp[i][j-coins[i-1]] : 0;
                int noPick = dp[i-1][j];

                dp[i][j] = pick + noPick;
            }
        }
        return dp[n][target];
    }
}
