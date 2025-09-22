public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        // right pointer is max from piles list, used to set boundary
        // for successful eating speed in the least optimal case - Koko prefers eating slowly
        int r = Arrays.stream(piles).max().getAsInt();
        int result = r;

        while (l <= r) {
            // midpoint is the eating speed we're testing 
            int k = (l + r) / 2;
            int hours = 0;
            for (int pile : piles) {
                // accumulate rounded up hours, using pile value / speed k
                hours += Math.ceil((double) pile / k);
            }
        
            // if hours comes in under h hours
            if (hours <= h) {
                // new result is our current speed
                result = k;
                r = k - 1;
            } else {
                // else move left pointer, because koko needs to eat faster
                l = k + 1;
            }

            // as long as l <= r, we're going to keep going 
            // to find the slowest speed k
        }

        return result;
    }
}