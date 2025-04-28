class Solution {
    public double[] getCollisionTimes(int[][] cars) {
         int len = cars.length;
        Stack<Integer> stack = new Stack<>();
        double ans[] = new double[len];
        for(int i=len-1;i>=0;i--){
            while(!stack.isEmpty()){
                if(cars[stack.peek()][1] >= cars[i][1] ||
                        (ans[stack.peek()] != -1 && ans[stack.peek()] < calculate(cars[stack.peek()],cars[i]))){
                    stack.pop();
                }else
                    break;
            }

            if(stack.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = calculate(cars[stack.peek()],cars[i]);
            }
            stack.push(i);
        }
        return ans;
    }
    public double calculate(int[]car1, int[] car2){
        
        double ans =  ((double)(car2[0] - car1[0]))/(double)(car1[1] - car2[1]);
        return ans;
    }
}