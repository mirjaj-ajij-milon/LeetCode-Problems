class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int nonZPos = 0;
        // int arr[] = new int[n];

        for(int i=0; i<n; i++){
           if(nums[i] != 0){
            nums[nonZPos++] = nums[i];
           }
        }

        while(nonZPos < n){
            nums[nonZPos++] = 0;
        }
    }
}