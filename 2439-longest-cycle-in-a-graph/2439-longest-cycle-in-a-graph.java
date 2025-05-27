class Solution {
    Map<Integer,List<Integer>> graph = new HashMap<>();
    private int ans = -1;
    public int longestCycle(int[] edges) {
        for(int i=0;i<edges.length;i++){
            graph.put(i,new ArrayList<>());
            if(edges[i] != -1)
                graph.get(i).add(edges[i]);
        }
        Set<Integer> visited = new HashSet<>();
        Map<Integer,Integer> visiting = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            if(visited.contains(i) == false){
                findCycles(i,visiting,visited);
            }
            visited.addAll(visiting.keySet());
            visiting.clear();
        }
        return ans;
    }
    public boolean findCycles(int node,Map<Integer,Integer> visiting,Set<Integer> visited){
        visiting.put(node,visiting.size());

        for(Integer ngh : graph.get(node)){
            if (visiting.containsKey(ngh)) {
                int size = visiting.size() - visiting.get(ngh);
                ans = Math.max(ans,size);
                return true;
            }
            if(!visited.contains(node)){
                if(findCycles(ngh,visiting,visited)){
                    return true;
                }
            }
        }
        visited.add(node);
        visiting.remove(node);
        return false;
    }
}