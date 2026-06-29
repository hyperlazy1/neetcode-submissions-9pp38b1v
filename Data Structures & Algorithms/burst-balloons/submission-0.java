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

        for(int i=0;i<n+2;i++){
            Arrays.fill(dp[i],-1);
        }
        return ans(tmp, 1, n, dp);
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
