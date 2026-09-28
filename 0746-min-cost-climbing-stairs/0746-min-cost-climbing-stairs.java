class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return Math.min(help(0, cost, dp), help(1, cost, dp));
    }

    private int help(int i, int cost[], int dp[]) {
        if (i >= cost.length)
            return 0;
        if (dp[i] != -1) {
            return dp[i];
        }

        dp[i] = cost[i] + Math.min(help(i + 1, cost, dp), help(i + 2, cost, dp));
        return dp[i];
    }
}