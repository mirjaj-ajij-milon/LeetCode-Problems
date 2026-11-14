class Solution {
    public void moveZeroes(int[] nums) {
        int notZeroPos = 0;
        int n = nums.length;

        // Every not zero element put at start of array
        for(int i=0; i<n; i++){
            if(nums[i] != 0){
                nums[notZeroPos++] = nums[i];
                // notZeroPos++;
            }
        }


        // Remaining Size fill with Zeros
        while(notZeroPos < n){
            nums[notZeroPos++] = 0;
        }
    }
}