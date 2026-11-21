class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int t = target;
        int l = 0; int r = n-1;

        while(l <= r){
            int mid = l + (r-l)/2;

            if(nums[mid] == t){
                return mid;
            }else if(nums[mid] > t){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        // if not Found the return left idx or right+1
        return r+1;
    }
}