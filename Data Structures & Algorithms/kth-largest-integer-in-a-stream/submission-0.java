class KthLargest {
    PriorityQueue<Integer> minQ;
    int k;

    public KthLargest(int k, int[] nums) {
        this.minQ = new PriorityQueue<>();
        this.k = k;
        for (int num: nums) {
            minQ.add(num);
        }

        while(minQ.size() > k) {
            minQ.poll();
        }
    }
    
    public int add(int val) {
       minQ.add(val);
       if (minQ.size() > k) {
        minQ.poll();
       }
       return minQ.peek();
    }
}
