class Solution {
    private static final String INTEGER_REGEX = "-?\\d+";
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk =  new Stack<>();
        int n = tokens.length;
        int ans  = 0;
        for(int i=0;i<n;i++){
            String str = tokens[i];
            if(str.matches(INTEGER_REGEX)){
                stk.add(Integer.parseInt(str));
            }else{
                int secondNumber = stk.pop();
                int firstNumber = stk.pop();
                int result = 0;
                if(str.equals("+")){
                    result =firstNumber + secondNumber;
                }else if(str.equals("*")){
                    result = firstNumber * secondNumber;
                }else if(str.equals("-")){
                    result = firstNumber - secondNumber;
                }else if(str.equals("/")){
                    result = firstNumber / secondNumber;
                }else{
                    System.out.println("invalid input");
                    return -1;
                }
                stk.add(result);
            }
        }
        return stk.peek();
    }
}