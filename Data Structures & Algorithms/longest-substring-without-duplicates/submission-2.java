class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        // store char and index where it was last seen
        Map<Character, Integer> lastSeen = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right ++) {
            char c = s.charAt(right);
            if (lastSeen.containsKey(c)) {
                left = Math.max(left, lastSeen.get(c) + 1);
            }
            lastSeen.put(c, right);
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
