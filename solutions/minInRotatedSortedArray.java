class Solution {
    public int findMin(int[] nums) {
        // initialize two pointers
        int l = 0, r = nums.length - 1;
        // default result value
        int res = nums[0];

        while (l <= r) {
            // if true, an indication we're in a sorted portion, likely with the 
            // left pointer at the min value
            if (nums[l] < nums[r]) {
                // update result and break
                res = Math.min(res, nums[l]);
                break;
            }

            // midpoint used for decision to move pointers
            int mid = (l + r) / 2;
            res = Math.min(res, nums[mid]);
            // if true, we're in a sorted portion of the array, search the left half
            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            // else, search the other half to try to find the beginning of the left sorted half
            } else {
                r = mid - 1;
            }
        }

        return res;
    }
}