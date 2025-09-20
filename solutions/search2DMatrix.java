class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // last elem of inside array 
        int m = matrix[0].length - 1;
        // two pointers used to find inside array to search
        int l = 0, r = matrix.length - 1;

        while (l <= r) {
            // middle array index between two pointers
            int mid = (l + r) / 2;
            // if first elem of middle array is greater than target, move right pointer
            if (matrix[mid][0] > target) {
                r = mid - 1;
            // if last elem of middle array is less than target, move left pointer
            } else if (matrix[mid][m] < target) {
                l = mid + 1;
            // else, target elem will be in current array
            } else {
                // normal binary search from here
                int leftP = 0, rightP = m;
                while (leftP <= rightP) {
                    int midpoint = (leftP + rightP) / 2;
                    if (matrix[mid][midpoint] > target) {
                        rightP = midpoint - 1;
                    } else if (matrix[mid][midpoint] < target) {
                        leftP = midpoint + 1;
                    } else {
                        return true;
                    }
                }
                // break after while loop, otherwise while loop above keeps going
                break;
            }
        }

        return false;
    }
}