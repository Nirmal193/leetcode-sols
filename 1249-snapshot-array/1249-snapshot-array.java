class SnapshotArray {

    Map<Integer,TreeMap<Integer,Integer>> snapshot;
    int currentVersion;
    public SnapshotArray(int length) {
        snapshot = new HashMap<>();
        currentVersion = 0;
        IntStream.range(0,length).forEach(i->snapshot.put(i,new TreeMap<>()));
    }

    public void set(int index, int val) {
        snapshot.get(index).put(currentVersion,val);
    }

    public int snap() {
        return currentVersion++;
    }

    public int get(int index, int snap_id) {
         Map.Entry<Integer, Integer> entry = snapshot.get(index).floorEntry(snap_id);
        return entry == null ? 0 : entry.getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */