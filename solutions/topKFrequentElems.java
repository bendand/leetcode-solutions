class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // initialize a hashmap 
        Map<Integer, Integer> count = new HashMap<>();
        // count occurrences of each value
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // initialize array
        List<int[]> arr = new ArrayList<>();
        // add to int arr with each value, key in count hashmap
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            arr.add(new int[] {entry.getValue(), entry.getKey()});
        }
        // sort array by most frequently occurring elements
        arr.sort((a, b) -> b[0] - a[0]);   

        // initialize result array with size of k
        int[] res = new int[k];
        // add k most frequent elements to result array
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }
        return res;
    }
}