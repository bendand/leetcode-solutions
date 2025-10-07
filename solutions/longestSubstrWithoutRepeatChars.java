class Solution {
    public int lengthOfLongestSubstring(String s) {
        // hashset coupled with left pointer enables efficient access and removal from set
        HashSet<Character> curChars = new HashSet<>();
        int l = 0;
        // max substring length
        int res = 0;

        for (int r=0; r < s.length(); r++) {
            // if hashset contains current character, remove chars at left pointer until 
            // current character is removed
            while (curChars.contains(s.charAt(r))) {
                curChars.remove(s.charAt(l));
                // increment pointer after each ordinal removal
                l++;
            }              

            // add cur char to hashset and update result
            curChars.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}