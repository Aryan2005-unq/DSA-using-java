class TimeMap {
    private Map<String,TreeMap<Integer,String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key,k -> new TreeMap<>()).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer,String> tree = map.get(key);
        if(tree == null){
            return "";
        }
        Map.Entry<Integer,String> entry = tree.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

🔹 Time-Based Key-Value Store — Last-Moment Explanation

Stores values for a key along with timestamps.

Uses a HashMap where:

Key → String

Value → TreeMap<timestamp, value> (timestamps sorted)

🔁 Operations
set(key, value, timestamp)

If key doesn’t exist, create a new TreeMap.

Store (timestamp → value) in the TreeMap.

get(key, timestamp)

Fetch the TreeMap for the key.

Use floorEntry(timestamp) to find the latest value at or before the given timestamp.

Return the value if found, else return empty string.

🧠 Key Idea

TreeMap keeps timestamps sorted and allows efficient lookup of closest past time.
