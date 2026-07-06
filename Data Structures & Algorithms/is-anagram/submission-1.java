class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (char c: s.toCharArray()) {
            int freq = sMap.getOrDefault(c, 0);
            freq++;
            sMap.put(c, freq);
        }

        for (char c: t.toCharArray()) {
            int freq = tMap.getOrDefault(c, 0);
            freq++;
            tMap.put(c, freq);
        }

        return sMap.equals(tMap);
    }
}
