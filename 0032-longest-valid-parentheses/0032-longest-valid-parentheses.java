class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int ans = 0;

        for (int i = 1; i < n; i++) {

            if (s.charAt(i) == ')') {

                // Case: ()
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2 + (i >= 2 ? dp[i - 2] : 0);
                }

                // Case: ...))
                else if (i - dp[i - 1] - 1 >= 0 &&
                         s.charAt(i - dp[i - 1] - 1) == '(') {

                    dp[i] = dp[i - 1] + 2;

                    int j = i - dp[i - 1] - 2;
                    if (j >= 0)
                        dp[i] += dp[j];
                }

                ans = Math.max(ans, dp[i]);
            }
        }

        return ans;
    }
}