class TimeMap {
    Map<String,TreeMap<Integer,String>> timeline;
    public TimeMap() {
        timeline = new TreeMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeline.computeIfAbsent(key,v-> new TreeMap<>()).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(timeline.containsKey(key) == false)
            return "";
        Map.Entry<Integer,String> res = timeline.get(key).floorEntry(timestamp);
        return (res == null) ? ""  : res.getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */