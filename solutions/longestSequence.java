public class Solution {
    public int longestConsecutive(int[] nums) {
        // this set stores values of nums in num array
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        // max consecutive length
        int longest = 0;

        for (int num : numSet) {
            // if numSet doesnt have num directly to the left of num
            // num is determined to be the start of a sequence
            if (!numSet.contains(num - 1)) {
                int length = 1;
                // while num has num + 1
                while (numSet.contains(num + length)) {
                    length++;
                }
                // longest is updated if current streak is longest
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}