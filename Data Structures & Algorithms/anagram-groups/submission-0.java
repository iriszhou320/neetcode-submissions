class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();

        for (String s: strs) {
            Map<Character, Integer> freqMap = new HashMap<>();
            for (char c: s.toLowerCase().toCharArray()) {
                int freq = freqMap.getOrDefault(c, 0);
                freq++;
                freqMap.put(c, freq);
            }
            List<String> list = map.getOrDefault(freqMap, new ArrayList<String>());
            list.add(s);
            map.put(freqMap, list);
        }

        for (List<String> strings: map.values()) {
            res.add(strings);
        }
        return res;
    }
}
