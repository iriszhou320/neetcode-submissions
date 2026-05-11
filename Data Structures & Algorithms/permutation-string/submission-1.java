class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        Map<Character, Integer> count = new HashMap<>();
        for (char c: s1.toCharArray()) {
            int freq = count.getOrDefault(c, 0);
            count.put(c, freq + 1);
        }

        int left = 0;
        int size = s1.length();
        Map<Character, Integer> count2 = new HashMap<>();
        for (int right = 0; right < s2.length(); right++) {
            int freq = count2.getOrDefault(s2.charAt(right), 0);
            freq++;
            count2.put(s2.charAt(right), freq);

            if (right - left + 1 > size) {
                int f = count2.get(s2.charAt(left));
                if (f == 1) count2.remove(s2.charAt(left));
                else count2.put(s2.charAt(left), f - 1);
                left++;
            }
            
            if (count.equals(count2)) return true;
        }

        return false;
    }
}
