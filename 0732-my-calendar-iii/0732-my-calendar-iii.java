class MyCalendarThree {

    public TreeMap<Integer,Integer> timeline;
    public MyCalendarThree() {
        timeline = new TreeMap<>();
    }
    
    public int book(int startTime, int endTime) {
        timeline.put(startTime,timeline.getOrDefault(startTime,0)+1);
        timeline.put(endTime,timeline.getOrDefault(endTime,0)-1);
        int active = 0;
        int ans = 0; 
        for(Map.Entry<Integer,Integer> entry: timeline.entrySet()){
            active += entry.getValue();
            ans = Math.max(ans,active);
        }
        return ans;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */