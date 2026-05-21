class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone: stones) {
            maxQ.offer(stone);
        }

        while(maxQ.size() > 1) {
            int stone1 = maxQ.poll();
            int stone2 = maxQ.poll();
            if (stone1 == stone2) {
                continue;
            }

            if (stone2 < stone1) {
                maxQ.offer(stone1 - stone2);
            }

            if (stone1 < stone2) {
                System.out.println("error!");
            }
        }

        return maxQ.size() == 1 ? maxQ.poll() : 0;
    }
}
