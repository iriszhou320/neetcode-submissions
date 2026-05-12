class Solution {
    public int pivotIndex(int[] nums) {
        int l = nums.length;
        int[] prefixSum = new int[l];
        int[] postfixSum = new int[l];

        prefixSum[0] = nums[0];
        postfixSum[l-1] = nums[l-1];
        
        for (int i = 1; i < l; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        for (int i = l - 2; i >= 0; i--) {
            postfixSum[i] = postfixSum[i+1] + nums[i];
        }

        for (int i = 0; i < l; i++) {
            int preSum;
            int postSum;
            if (i == 0) {
                preSum = 0;
            } else {
                preSum = prefixSum[i-1];
            }

            if (i == l - 1) {
                postSum = 0;
            } else {
                postSum = postfixSum[i+1];
            }

            if (preSum == postSum) {
                return i;
            }
        }

        return -1;
    }
}