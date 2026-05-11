class Solution {
    public int maxArea(int[] heights) {
        // further - indexes, taller - height
        int max = 0; // heights cannot be negative
        int left = 0;
        int right = heights.length - 1;

        while(left < right) {
            int container = (right - left) * Math.min(heights[left], heights[right]);
            max = Math.max(max, container);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
