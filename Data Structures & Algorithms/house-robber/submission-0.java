class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp ,-1);
        return dfs(nums,0,dp);
    }

    private int dfs(int[] nums, int i, int[] dp){
        if(i>=nums.length) return 0;
        if(dp[i]!=-1) return dp[i];

        return dp[i] = Math.max(dfs(nums, i+1, dp), nums[i] + dfs(nums, i+2, dp));
    }
}
