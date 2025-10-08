public class Solution {
    public int characterReplacement(String s, int k) {
        // hashmap for maintaining character count of current window
        HashMap<Character, Integer> count = new HashMap<>();
        // default result value and left pointer
        int res = 0;
        int l = 0;
        // max frequency value, even if outdated by window size updates, still ensures validity
        int maxf = 0;

        for (int r = 0; r < s.length(); r++) {
            // add char to hashmap
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            // compute maxf 
            maxf = Math.max(maxf, count.get(s.charAt(r)));

            // while window is invalid
            while ((r - l + 1) - maxf > k) {
                // decrement current character value from hashmap and move left pointer forward
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }

            // res is our max valid window size
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}