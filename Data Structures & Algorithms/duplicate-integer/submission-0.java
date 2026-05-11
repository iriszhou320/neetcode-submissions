class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set uniqueNums = new HashSet<>();
        for (int num: nums) {
            if (uniqueNums.contains(num)) {
                return true;
            } else {
                uniqueNums.add(num);
            }
        }
        return false;
    }
}