class Solution {
    public void sortColors(int[] nums) {
        int[] counts = new int[3];
        for (int i = 0; i < counts.length; i++) {
            counts[i] = 0;
        }
        for (int num: nums) {
            counts[num]++;
        }

        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                nums[index] = i;
                index ++;
            }
        }
    }
}