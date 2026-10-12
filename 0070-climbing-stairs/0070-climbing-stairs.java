class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];

        dp[0] = 1; // 0th stair 1 way -> kahi na jau whi rahu

        for(int i=1; i<n+1; i++){
            if(i <= 1){
                dp[i] = dp[i-1]; // agar i <= 1 then i -ve ho jayega or uska val 0 
            }else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }
}