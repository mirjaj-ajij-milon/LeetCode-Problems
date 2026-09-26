class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n + 1][m + 1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                dp[i][j] = -1;
            }
        }
        return help(text1, text2, n, m, dp);
    }

    private int help(String str1, String str2, int n, int m, int dp[][]){
        if(n == 0 || m == 0){
            return 0;
        }

        if(dp[n][m] != -1){
            return dp[n][m];
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)){
            dp[n][m] =  help(str1, str2, n-1, m-1, dp) + 1;
            return dp[n][m];
        }else{
            int ans1 = help(str1, str2, n, m-1, dp);
            int ans2 = help(str1, str2, n-1, m, dp);
            dp[n][m] = Math.max(ans1, ans2);
            return dp[n][m];
        }
    }
}