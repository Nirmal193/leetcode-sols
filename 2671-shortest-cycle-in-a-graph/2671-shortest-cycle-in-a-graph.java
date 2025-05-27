class Solution {
    private Map<Integer,List<Integer>> graph = new HashMap<>();
    private int ans;
    public int findShortestCycle(int n, int[][] edges) {
        ans = n;
        int len = edges.length;
        for(int i=0;i<n;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int i=0;i<len;i++){
            graph.computeIfAbsent(edges[i][0],k->new ArrayList<>()).add(edges[i][1]);
            graph.computeIfAbsent(edges[i][1],k->new ArrayList<>()).add(edges[i][0]);
        }
        return findCycle(n);
    }
    public int findCycle(int n) {
        int minCycle = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int distance[] = new int[n];
            Arrays.fill(distance, Integer.MAX_VALUE);
            Queue<Integer> queue = new LinkedList<>();
            distance[i] = 0;
            queue.offer(i);
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                for (int neighbour : graph.get(curr)) {
                    if (distance[neighbour] == Integer.MAX_VALUE) {
                        distance[neighbour] = distance[curr] + 1;
                        queue.offer(neighbour);
                    } else if (distance[neighbour] >= distance[curr]) {
                        minCycle = Math.min(minCycle, distance[curr] + 1 + distance[neighbour]);
                    }
                }
            }
        }
        return minCycle == Integer.MAX_VALUE ? -1 : minCycle;
    }
}