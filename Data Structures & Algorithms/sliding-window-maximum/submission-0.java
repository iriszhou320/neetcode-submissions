class Solution {
    class Record {
        int index;
        int value;

        public Record(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int left = 0;
        int max = Integer.MIN_VALUE;
        PriorityQueue<Record> pq = new PriorityQueue<Record>((a, b) -> b.value - a.value);

        for (int right = 0; right < nums.length; right++) {
            pq.offer(new Record(right, nums[right]));

            if (right - left + 1 >= k) {
                while(pq.peek().index < left) {
                    pq.poll();
                }
                max = pq.peek().value;
                System.out.println(max);
                System.out.println(left);
                res[left] = max;
                left++;
            }
        }
        return res;
    }
}
