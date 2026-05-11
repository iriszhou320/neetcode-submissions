class Solution {
    class Record {
        int temp;
        int index;

        public Record(int temp, int index) {
            this.temp = temp;
            this.index = index;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Record> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            while(!stack.isEmpty() && stack.peek().temp < temp) {
                Record prev = stack.pop();
                res[prev.index] = i - prev.index;
            }
            stack.push(new Record(temp, i));
        }
        return res;
    }
}
