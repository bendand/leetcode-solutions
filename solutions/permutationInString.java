public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // if s1 is longer than s2, a permutation is impossible
        if (s1.length() > s2.length()) {
            return false;
        }

        // initialize and create character count keys for both strings
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // count how many character counts match at current window
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                matches++;
            }
        }


        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            // if all frequency counts match at current window, return true
            if (matches == 26) {
                return true;
            }

            // get index of current character and increment character in s2 window
            int index = s2.charAt(r) - 'a';
            s2Count[index]++;
            // if new frequency of character matches s1Count, increment matches
            if (s1Count[index] == s2Count[index]) {
                matches++;
                // else if new frequency of character is s1Count + 1, we have lost a match, decrement
            } else if (s1Count[index] + 1 == s2Count[index]) {
                matches--;
            }

            // get index of character at left pointer and decrement char in current window
            index = s2.charAt(l) - 'a';
            s2Count[index]--;
            // if new frequency of character matches s1Count, increment matches
            if (s1Count[index] == s2Count[index]) {
                matches++;
            } else if (s1Count[index] - 1 == s2Count[index]) {
                // else if new frequency of character is s1Count + 1, we have lost a match, decrement
                matches--;
            }
            // increment left pointer
            l++;
        }

        return matches == 26;
    }
}