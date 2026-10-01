class Solution {
    public int lengthOfLIS(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int ele : nums){
            set.add(ele);
        }

        int arr2[] = new int[set.size()];
        int i=0;
        for(int ele : set){
            arr2[i] = ele;
            i++;
        }
        Arrays.sort(arr2);

        return LCS(nums, arr2);
    }

    private int LCS(int arr1[], int arr2[]){
        int n = arr1.length;
        int m = arr2.length;

        int dp[][] = new int [n+1][m+1];

        // initilize bydefault do java with i=0 -> 0 and j=0 -> 0

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    int ans1 = dp[i][j-1];
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        return dp[n][m];
    }
}