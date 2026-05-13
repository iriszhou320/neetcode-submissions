class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // find the pivot min first
        int minIndex = 0;
        int min = nums[0];

        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[nums.length-1] < target) {
            return binarySearch(0, left, nums, target);
        } else {
            return binarySearch(left, nums.length-1, nums, target);
        }
    }

    private int binarySearch(int left, int right, int[] nums, int target) {
        System.out.println(left);
        System.out.println(right);
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
