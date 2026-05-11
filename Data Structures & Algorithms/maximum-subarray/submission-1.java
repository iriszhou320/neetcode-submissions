class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int[] maxSums = new int[nums.length];
        maxSums[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (maxSums[i-1] < 0) {
                maxSums[i] = nums[i];
            } else {
                maxSums[i] = maxSums[i-1] + nums[i];
            }
            System.out.println(maxSums[i]);
        }
        int res = maxSums[0];
        for (int max: maxSums) {
            res = Math.max(res, max);
        }

        return res;
    }
}
