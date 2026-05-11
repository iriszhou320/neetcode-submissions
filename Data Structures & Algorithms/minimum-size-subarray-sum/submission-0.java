class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) return 0;
        int left = 0;
        int currentSum = 0;
        int min = Integer.MAX_VALUE;

        for(int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            while (currentSum >= target) {
                currentSum -= nums[left];
                min = Math.min(min, right-left+1);
                left++;
            } 
        }
        if (min == Integer.MAX_VALUE) return 0;
        return min;
    }
}