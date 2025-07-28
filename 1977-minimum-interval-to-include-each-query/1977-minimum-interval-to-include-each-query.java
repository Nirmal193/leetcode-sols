class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        List<Integer[]> interval = new LinkedList<>();
        int len = intervals.length;
        for(int i = 0; i < len; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            int length = end - start + 1;
            interval.add(new Integer[]{start, -length, -1});
            interval.add(new Integer[]{end, length, -1});
        }

        for(int i = 0; i < queries.length; i++){
            interval.add(new Integer[]{queries[i], 0, i});
        }

        Collections.sort(interval, (a, b) -> {
            if(a[0].equals(b[0])) return a[1] - b[1];
            return a[0] - b[0];
        });

        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        int[] ans = new int[queries.length];

        for(Integer[] intr : interval){
            if(intr[1] < 0){
                tmap.compute(-intr[1], (key, val) -> val == null ? 1 : val + 1);
            } else if(intr[1] > 0){
                tmap.compute(intr[1], (key, val) -> val == 1 ? null : val - 1);
            } else {
                int idx = intr[2];
                ans[idx] = tmap.isEmpty() ? -1 : tmap.firstKey();
            }
        }

        return ans;
    }
}