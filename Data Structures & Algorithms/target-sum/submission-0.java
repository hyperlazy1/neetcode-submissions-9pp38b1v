class Solution {
    int total=0;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        for(int num:nums){
            total+=num;
        }
        int dp[][] = new int[n][(2*total)+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return ans(nums, target, n-1, 0, dp);
    }

    private int ans(int[] nums, int target, int i, int sum, int dp[][]){
        if(i<0){
            return target==sum ? 1:0;
        }
        if(dp[i][sum+total] != -1) return dp[i][sum+total];

        int add = ans(nums, target, i-1, sum+nums[i], dp);
        int sub = ans(nums, target, i-1, sum-nums[i], dp);

        return dp[i][sum+total] = add+sub;
    }
}
