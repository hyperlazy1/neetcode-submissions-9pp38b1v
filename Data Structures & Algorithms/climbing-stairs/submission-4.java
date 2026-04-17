public class Solution {
    int[] cache;
    public int climbStairs(int n) {
        cache = new int[n+1];
        cache[0] = 1;
        cache[1] = 1;

        for(int i=2; i<=n; i++){
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n];
    }
}