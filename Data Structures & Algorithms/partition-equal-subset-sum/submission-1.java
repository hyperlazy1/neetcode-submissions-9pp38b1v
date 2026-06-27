public class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        Boolean[][] dp = new Boolean[nums.length][target + 1];

        return isPossible(dp, target, 0, nums);
    }

    private boolean isPossible(Boolean[][] dp, int target, int i, int[] nums){
        if(target==0) return true;
        if(i==nums.length) return false;
        if(dp[i][target] != null) return dp[i][target];

        boolean notTake = isPossible(dp, target, i+1, nums);
        boolean take = false;
        if(nums[i]<=target){
            take = isPossible(dp, target-nums[i], i+1, nums);
        }
        return dp[i][target] = take || notTake;
    }
}