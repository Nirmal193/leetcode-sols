class StockPrice {

   Map<Integer,Integer> map;
    TreeMap<Integer,Integer> tmap;
    int currentTime;
    int currentPrice;
    public StockPrice() {
        map = new HashMap<>();
        tmap = new TreeMap<>();
        currentTime = 0;
        currentPrice = 0;
    }

    public void update(int timestamp, int price) {
         if(map.containsKey(timestamp)) {
            tmap.compute(map.get(timestamp), (k, v) -> v == null || v == 1 ? null : v - 1);
        }
        tmap.compute(price,(k,v)->v==null ? 1 : v + 1);
        map.put(timestamp,price);
        if(timestamp >= currentTime){
            currentPrice = price;
            currentTime = timestamp;
        }
    }

    public int current() {
        return currentPrice;
    }

   public int maximum() {
        return  tmap.lastKey() == null ? -1 : tmap.lastKey();
    }

    public int minimum() {
        return tmap.firstKey()== null ? -1 : tmap.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */