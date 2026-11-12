class Solution {
    public int search(int[] nums, int target) {
        // for(int i=0; i<nums.length; i++){ //Linear Search
        //     if(nums[i] == target){
        //         return i;
        //     }
        // }
        // return -1;
        int n = nums.length;

        int l = 0;
        int r = n - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        int shift = l; // r bcz after loop end r == l

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int shiftMid = (mid + shift) % n;

            if (nums[shiftMid] == target) {
                return shiftMid;
            } else if (nums[shiftMid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}