class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
         List<int[]> heights = new ArrayList<>();
        for (int[] building : buildings) {
            heights.add(new int[]{building[0], -building[2]});
            heights.add(new int[]{building[1], building[2]});
        }

        heights.sort((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1]; 
        });

        List<List<Integer>> result = new ArrayList<>();
        TreeMap<Integer, Integer> heightMap = new TreeMap<>();
        heightMap.put(0, 1);  
        int prevHeight = 0;

        for (int[] height : heights) {
            if (height[1] < 0) {  
                heightMap.compute(-height[1], (key, value) ->
                        value == null ? 1 : value + 1);
            } else {  
                heightMap.compute(height[1], (key, value) ->
                        value == 1 ? null : value - 1);
            }

            int currentHeight = heightMap.lastKey();
            if (currentHeight != prevHeight) {
                result.add(List.of(height[0], currentHeight));
                prevHeight = currentHeight;
            }
        }

        return result;
    }
}