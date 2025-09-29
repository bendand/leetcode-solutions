public class TimeMap {
    private Map<String, List<Pair<Integer, String>>> keyStore;

    public TimeMap() {
        keyStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        // adds timestamp, value pair to key, and adds key before adding timestamp, value pair
        // if there is no key at time of operation
        keyStore.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }

    public String get(String key, int timestamp) {
        // get list of pairs from key's values
        List<Pair<Integer, String>> values = keyStore.getOrDefault(key, new ArrayList<>());
        // initialize two pointers 
        int left = 0, right = values.size() - 1;
        // default result
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // if mid timestamp's value <= timestamp
            if (values.get(mid).getKey() <= timestamp) {
                // we're going to make this timestamp value our temporary result
                result = values.get(mid).getValue();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    // static class used in TimeMap for easy access of keys and values
    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}