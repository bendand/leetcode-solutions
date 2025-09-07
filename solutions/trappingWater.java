class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        // initialize two pointers
        int l = 0; int r = height.length - 1;

        while (l < r) {
            // distance from left to right post
            int distance = r - l;
            // anything above lesser height will overflow
            int minHeight = Math.min(height[l], height[r]);

            // set max area to max of current area and current max
            maxArea = Math.max(maxArea, distance * minHeight);

            // maximize height -> maximum surface area
            if (height[l] >= height[r]) {
                r--;
            } else {
                l++;
            }
        }

        return maxArea;
    }
}