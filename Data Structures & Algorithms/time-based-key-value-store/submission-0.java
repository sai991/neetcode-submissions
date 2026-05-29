class TimeMap {

    private HashMap<String, List<String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        List<String> list = map.get(key);
        list.add(value);                          // even index → value
        list.add(String.valueOf(timestamp));      // odd index  → timestamp
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<String> list = map.get(key);
        int lo = 0;
        int hi = (list.size() / 2) - 1;
        int result = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int midTime = Integer.parseInt(list.get(mid * 2 + 1));  // odd index

            if (midTime <= timestamp) {
                result = mid;   // potential answer, search right
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return result == -1 ? "" : list.get(result * 2);  // even index → value
    }
}