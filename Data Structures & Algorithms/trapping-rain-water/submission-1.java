class Solution {
    public int trap(int[] height) {
        int[] prefixMax = new int[height.length];
        int[] suffixMax = new int[height.length];
        int totalWater = 0;

        int preMax = Integer.MIN_VALUE;
        int sufMax = Integer.MIN_VALUE;
        prefixMax[0] = Integer.MIN_VALUE;
        suffixMax[height.length-1] = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            prefixMax[i] = preMax;
            preMax = Math.max(preMax, height[i]);
        }

        for (int i = height.length - 1; i >= 0; i--) {
            suffixMax[i] = sufMax;
            sufMax = Math.max(sufMax, height[i]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            int maxHeight = Math.min(prefixMax[i], suffixMax[i]);
            if (maxHeight >= height[i]) {
                totalWater += (maxHeight - height[i]) * 1;
            }
        }

        return totalWater;
    }
}
