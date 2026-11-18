class Solution {
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int lead = 1;

        // Time -> O(n)
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == major) {
                lead++;
            } else if (lead > 0) {
                lead--;
            } else {
                major = nums[i];
                lead = 1;
            }
        }

        return major;
    }
}