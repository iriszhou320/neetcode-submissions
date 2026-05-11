class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token: tokens) {
            if (isNumber(token)) {
                stack.push(token);
            } else {
                int s2 = Integer.valueOf(stack.pop());
                System.out.println(token);
                int s1 = Integer.valueOf(stack.pop());
                int res = calculate(s1, s2, token);
                stack.push(String.valueOf(res));
            }
        }
        return Integer.valueOf(stack.pop());
    }

    private boolean isNumber(String s) {
        boolean b = !(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
        return b;
    }

    private int calculate(int s1, int s2, String op) {
        if (op.equals("+")) return s1 + s2;
        if (op.equals("-")) return s1 - s2;
        if (op.equals("*")) return s1 * s2;
        if (op.equals("/")) return s1 / s2;
        return 0;
    }
}
