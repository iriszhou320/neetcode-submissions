class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // rolling window set to track duplicates
        Set<Integer> set = new HashSet<>();
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if ((right - left) > k) {
                set.remove(nums[left]);
                left++;
            } 
                System.out.println(nums[right]);
                if (set.contains(nums[right])) {
                    return true;
                }
                System.out.println(left);
                System.out.println(right);
                set.add(nums[right]);
        
        }

        return false;
    }
}