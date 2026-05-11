class Solution {
    public boolean isValid(String s) {
        Stack<Character> p = new Stack<Character>();
        if (s.length()%2 != 0) return false;
        for (char c: s.toCharArray()) {
            if (c == ']') {
                if (p.size() == 0 || p.pop() != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (p.size() == 0 || p.pop() != '{') {
                    return false;
                }
            } else if (c == ')') {
                if (p.size() == 0 || p.pop() != '(') {
                    return false;
                }
            } else {
                p.push(c);
            }
        }
        return p.isEmpty();
    }
}
