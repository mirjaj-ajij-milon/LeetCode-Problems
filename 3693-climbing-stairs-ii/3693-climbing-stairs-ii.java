class Solution {
    public int climbStairs(int n, int[] costs) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return help(n, costs, dp);
    }

    public int help(int n, int costs[], int dp[]) {

        if (n == 0) {
            return 0;
        }

        if (n < 0) {
            return Integer.MAX_VALUE / 2;
        }
        if(dp[n] != -1){
            return dp[n];
        }

        int one = help(n - 1, costs, dp) + costs[n - 1] + 1;

        int two = help(n - 2, costs, dp) + costs[n - 1] + 4;

        int three = help(n - 3, costs, dp) + costs[n - 1] + 9;

        return dp[n] = Math.min(one, Math.min(two, three));
    }
}