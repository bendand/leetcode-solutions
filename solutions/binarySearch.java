class Solution {
    public int search(int[] nums, int target) {
        // initialize two pointers
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            // calculate midpoint index
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                // effectively eliminate right half of array if nums[mid] is greater than target
                r = mid - 1;
            } else {
                // effectively eliminate left half of array if nums[mid] is less than target
                l = mid + 1;
            }
        }

        return -1;
    }
}