class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int currMin = 1;
        int currMax = 1;

        for(int num: nums){
            int product = currMax * num;
            currMax = Math.max(num, Math.max(currMax * num, num * currMin));
            currMin = Math.min(num, Math.min(num * currMin, product));
            res = Math.max(res, currMax);
        }

        return res;
    }
}
