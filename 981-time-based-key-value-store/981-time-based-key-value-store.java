class TimeMap {

    HashMap<String, HashMap<Integer, String>> keyTimeMap;
    public TimeMap() {
        keyTimeMap = new HashMap<String, HashMap<Integer, String>>();
    }
    public void set(String key, String value, int timestamp) {
        if (!keyTimeMap.containsKey(key)) {
            keyTimeMap.put(key, new HashMap<Integer, String>());
        }
        keyTimeMap.get(key).put(timestamp, value);
    }
    public String get(String key, int timestamp) {
        if (!keyTimeMap.containsKey(key)) {
            return "";
        }
        for (int currTime = timestamp; currTime >= 1; --currTime) {
            if (keyTimeMap.get(key).containsKey(currTime)) {
                return keyTimeMap.get(key).get(currTime);
            }
        }
        return ""; 
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */