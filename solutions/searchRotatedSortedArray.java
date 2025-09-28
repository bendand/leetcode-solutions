class Solution {
    public int search(int[] nums, int target) {
        // initialize two pointers
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            // if nums mid is our target return mid
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // if we're in a sorted portion of the array
            if (nums[l] <= nums[mid]) {
                // if target is outside of left portion, move left pointer outside of portion
                if (target > nums[mid] || target < nums[l]) {
                    l = mid + 1;
                // else move our right pointer inside left portion
                } else {
                    r = mid - 1;
                }
            // we're not in a sorted portion of the array
            } else {
                // if target is less than our mid val or greater than our right most val
                // search in left portion
                if (target < nums[mid] || target > nums[r]) {
                    r = mid - 1;
                // else search in right portion
                } else {
                    l = mid + 1;
                }
            }
        }

        return -1;
    }
}