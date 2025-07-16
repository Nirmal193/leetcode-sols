class CountIntervals {

    TreeMap<Integer,Integer> timeline;
    int count = 0;
    public CountIntervals(){
        timeline = new TreeMap<>();
    }
    public void add(int left, int right) {
        Integer start = timeline.floorKey(left);
        if(start == null || timeline.get(start) < left ) start = timeline.ceilingKey(left);
        int newleft = left;
        int newright = right;
        while(start != null && start <= newright && timeline.get(start) >= newleft){
            newleft = Math.min(newleft,start);
            newright = Math.max(newright,timeline.get(start));
            count -= (timeline.get(start) - start + 1);
            timeline.remove(start);
            start = timeline.higherKey(start);
        }
        count += newright - newleft + 1;
        timeline.put(newleft,newright);
    }

    public int count() {
        return count;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */