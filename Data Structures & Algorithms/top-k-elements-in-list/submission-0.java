class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: nums) {
            int freq = count.getOrDefault(num, 0);
            freq++;
            count.put(num, freq);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            buckets[freq].add(num);
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = buckets.length -1; i > 0; i--) {
            for (int num: buckets[i]) {
                if (index == k) {
                    return res;
                }
                System.out.print(num);
                res[index] = num;
                index++;
            }
        }
        return res;
    }
}
