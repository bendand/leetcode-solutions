class Solution {
    public boolean isPalindrome(String s) {
        char[] strToArr = s.toCharArray();
        // left pointer
        int l = 0;
        // right pointer
        int r = strToArr.length - 1;
        
        while (l < r) {
            // Skip non alphanumeric characters from the left
            while (l < r && !Character.isLetterOrDigit(strToArr[l])) {
                l++;
            }
            // Skip non alphanumeric characters from the right
            while (l < r && !Character.isLetterOrDigit(strToArr[r])) {
                r--;
            }

            // convert letters to lowercase for comparison
            if (Character.toLowerCase(strToArr[l]) != Character.toLowerCase(strToArr[r])) {
                return false;
            }

            // increment left, decrement right on each successful comparison
            l++;
            r--;
        }

        return true;
    }
}