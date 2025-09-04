class Solution {
    // def: prefix product is product of nums before num at i index
    // def: postfix product is product of nums after num at i index
    public int[] productExceptSelf(int[] nums) {
        // initialize arrays to calculate products
        int[] prefixArray = new int[nums.length];
        int[] postfixArray = new int[nums.length];
        int[] resultArray = new int[nums.length];

        // prefix/postfix products are initialized with 1
        int prefixProduct = 1;
        int postfixProduct = 1;

        // each elem in nums is given the cur prefix product 
        for (int i = 0; i < nums.length; i++) {
            prefixArray[i] = prefixProduct;
            // prefix product is updated 
            prefixProduct = prefixProduct * nums[i];
        }

        // each elem in nums is given the cur postfix product 
        for (int i = nums.length - 1; i >= 0; i--) {
            postfixArray[i] = postfixProduct;
            // postfix product is updated 
            postfixProduct = postfixProduct * nums[i];
        }


        // for each index i in result array
        for (int i = 0; i < nums.length; i++) {
            // products before nums i and after nums i are multiplied
            resultArray[i] = prefixArray[i] * postfixArray[i];
        }

        return resultArray;
    }
}