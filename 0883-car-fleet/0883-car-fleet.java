class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Node> cars = new ArrayList<>();
        int len = speed.length;
        for(int i=0;i<len;i++){
            cars.add(new Node(speed[i],position[i]));
        }
        Collections.sort(cars,Comparator.<Node>comparingInt(a->a.position)
        .thenComparingInt(a->a.speed)
        .reversed());
        Stack<Double> stack = new Stack<>();
        int ans = 0;
        for(Node car : cars){
            int distance = target - car.position;
            double time = (double)distance/car.speed;
            if(stack.isEmpty() || stack.peek() < time){
                stack.push(time);
                ans++;
            }
        }
        return ans;
    }
    private static class Node{
        public int speed;
        public int position;
        public Node(int speed, int position){
            this.speed = speed;
            this.position = position;
        }
    }
}