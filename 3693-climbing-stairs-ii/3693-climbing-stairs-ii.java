
class Solution {
    public int climbStairs(int n, int[] costs) {

        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1); // -1 means not calculated yet

        return help(n, costs, dp);
    }

    public int help(int n, int costs[], int dp[]) {

        if (n == 0) {
            return 0; // Reached step 0, no cost needed
        }

        if (n < 0) {
            return Integer.MAX_VALUE / 2; // Invalid step
        }

        if (dp[n] != -1) {
            return dp[n]; // Return already calculated answer
        }

        // Reach step n by jumping from step n-1
        int one = help(n - 1, costs, dp) + costs[n - 1] + 1;

        // Reach step n by jumping from step n-2
        int two = help(n - 2, costs, dp) + costs[n - 1] + 4;

        // Reach step n by jumping from step n-3
        int three = help(n - 3, costs, dp) + costs[n - 1] + 9;

        // Store the minimum cost to reach step n
        return dp[n] = Math.min(one, Math.min(two, three));
    }
}
