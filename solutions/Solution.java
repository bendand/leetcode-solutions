public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sorting the array makes avoiding duplicates easier 
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // if nums[i] is greater than 0 3sum won't work from this point
            if (nums[i] > 0) break;
            // continue loop as long as nums[i] is equal to nums[i-1]
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // essentially 2Sum at this point
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // we continue our while loop here as unique permutations are still possible
                    l++;
                    r--;
                    // skip repeated values on our left pointer
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }
            }
        }
        return res;
    }
}