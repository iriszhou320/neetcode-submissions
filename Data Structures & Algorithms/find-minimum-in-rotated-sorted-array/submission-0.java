class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = nums[0];

        while (left < right) {
            int mid = left + (right - left) /2;
            if (nums[mid] < nums[right]) {
                min = Math.min(min, nums[mid]);
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left];
    }
}
