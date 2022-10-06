class TimeMap {

    // HashMap<String, HashMap<Integer, String>> keyTimeMap;
    // public TimeMap() {
    //     keyTimeMap = new HashMap<String, HashMap<Integer, String>>();
    // }
    // public void set(String key, String value, int timestamp) {
    //     if (!keyTimeMap.containsKey(key)) {
    //         keyTimeMap.put(key, new HashMap<Integer, String>());
    //     }
    //     keyTimeMap.get(key).put(timestamp, value);
    // }
    // public String get(String key, int timestamp) {
    //     if (!keyTimeMap.containsKey(key)) {
    //         return "";
    //     }
    //     for (int currTime = timestamp; currTime >= 1; --currTime) {
    //         if (keyTimeMap.get(key).containsKey(currTime)) {
    //             return keyTimeMap.get(key).get(currTime);
    //         }
    //     }
    //     return ""; 
    // }
    
    //2nd solution
    Map<String, TreeMap<Integer,String>> map;
    public TimeMap() {
        this.map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!this.map.containsKey(key)){
            TreeMap<Integer,String> tmap=new TreeMap<>();
            tmap.put(timestamp,value);
            this.map.put(key,tmap);
        }else{
            this.map.get(key).put(timestamp,value);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!this.map.containsKey(key))return "";
        return this.map.get(key).floorEntry(timestamp)!=null?     this.map.get(key).floorEntry(timestamp).getValue():"";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */