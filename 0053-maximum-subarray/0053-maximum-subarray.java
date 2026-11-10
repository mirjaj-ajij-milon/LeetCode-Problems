class Solution {
    public int maxSubArray(int[] nums) {

        int currSum = nums[0]; // Assume the first element as the current sum
        int maxSum = nums[0]; // Assume the first element as the maximum sum

        for (int i = 1; i < nums.length; i++) {

            // Either start a new subarray or add the current element to the previous sum
            currSum = Math.max(nums[i], currSum + nums[i]);

            // Update maxSum if we find a bigger sum
            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum; // Return the maximum subarray sum
    }
}