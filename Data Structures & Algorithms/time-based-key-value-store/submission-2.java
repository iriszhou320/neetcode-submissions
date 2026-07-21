class TimeMap {
    class Record {
        String value;
        int timestamp;

        public Record(String val, int ts) {
            this.value = val;
            this.timestamp = ts;
        }
    }

    Map<String, List<Record>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Record> list = this.map.getOrDefault(key, new ArrayList<>());
        list.add(new Record(value, timestamp));
        this.map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        if (this.map.containsKey(key)) {
            List<Record> list = this.map.get(key);
            int left = 0;
            int right = list.size() - 1;
            // closest to timestamp
            int minIndex = Integer.MAX_VALUE;
            if (list.get(right).timestamp <= timestamp) return list.get(right).value;
            while (left <= right) {
                int mid = left + (right - left)/2;
                if (list.get(mid).timestamp <= timestamp) {
                    minIndex = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (minIndex == Integer.MAX_VALUE) return "";
            return list.get(minIndex).value;
        }

        return "";
    }
}
