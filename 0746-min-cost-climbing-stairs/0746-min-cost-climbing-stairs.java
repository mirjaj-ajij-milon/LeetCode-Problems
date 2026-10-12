class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);

        return Math.min(help(0, cost, dp), help(1, cost, dp)); // take 0 idx and 1 idx then take min of both
    }

    private static int help(int i, int arr[], int dp[]){
        if(i >= arr.length){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }
        return dp[i] = arr[i] + Math.min(help(i+1, arr, dp), help(i+2, arr, dp));
    }
}