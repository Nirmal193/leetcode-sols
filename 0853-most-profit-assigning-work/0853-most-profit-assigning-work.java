class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int ans = 0;
        TreeSet<Integer> set = new TreeSet<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int len = difficulty.length;
        Pair diff[] = new Pair[len];
        for (int i=0;i<len;i++){
            diff[i] = new Pair(difficulty[i],profit[i]);
        }
        Arrays.sort(diff, new Comparator<Pair>() {
            @Override
            public int compare(Pair t1, Pair t2) {
                return Integer.compare(t1.x,t2.x);
            }
        });
        for(int i=0;i<len;i++){
            set.add(diff[i].y);
            map.put(diff[i].x,Math.max(diff[i].y,set.last()));
        }
        set.clear();
        for(int i=0;i<worker.length;i++){
            Map.Entry<Integer, Integer> entry = map.floorEntry(worker[i]);
            if(entry != null){
                ans += entry.getValue();
            }
        }
        return ans;
    }
    public static class Pair{
        int x,y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}