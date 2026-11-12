class Solution {
    public int search(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){ //Linear Search
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }
}