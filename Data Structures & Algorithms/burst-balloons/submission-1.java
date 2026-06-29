class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n+2];
        tmp[0] = 1;
        for(int i=0;i<n;i++){
            tmp[i+1] = nums[i];
        }
        tmp[n+1] = 1;
        int dp[][] = new int[n+2][n+2];

        for(int i=n; i>=1; i--){
            for(int j=1; j<=n;j++){
                if(i>j) continue;
                int max = Integer.MIN_VALUE;
                for(int k = i; k<=j; k++){
                    int cost = tmp[i-1] * tmp[k] * tmp[j+1] + dp[i][k-1] +
                    dp[k+1][j];
                    max = Math.max(max, cost);
                }

                dp[i][j] = max;
            }
        }
        return dp[1][n];
    }

    private int ans(int[] tmp, int i, int j, int dp[][]){
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int max = Integer.MIN_VALUE;
        for(int k = i; k<=j; k++){
            int cost = tmp[i-1] * tmp[k] * tmp[j+1] + ans(tmp, i, k-1, dp) +
            ans(tmp, k+1, j, dp);
            max = Math.max(max, cost);
        }

        return dp[i][j] = max;
    }
}
