class TweetCounts {

    Map<String, TreeMap<Integer, Integer>> tweets;
    public TweetCounts() {
        tweets = new HashMap<>();
    }

    public void recordTweet(String tweetName, int time) {
        tweets.putIfAbsent(tweetName, new TreeMap<>());
        TreeMap<Integer, Integer> map = tweets.get(tweetName);
        map.put(time, map.getOrDefault(time, 0) + 1);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> chunks = new ArrayList<>();
        int interval = 0;
        switch (freq) {
            case "minute": interval = 60; break;
            case "hour":   interval = 3600; break;
            case "day":    interval = 86400; break;
        }
        int n = ((endTime - startTime) / interval) + 1;
        List<Integer> result = new ArrayList<>(Collections.nCopies(n, 0));

        if (!tweets.containsKey(tweetName)) return result;

        TreeMap<Integer, Integer> map = tweets.get(tweetName);
        for (Map.Entry<Integer, Integer> entry : map.subMap(startTime, true, endTime, true).entrySet()) {
            int time = entry.getKey();
            int count = entry.getValue();
            int index = (time - startTime) / interval;
            result.set(index, result.get(index) + count);
        }
        return result;
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */