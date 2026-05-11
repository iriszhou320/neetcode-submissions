class Solution {

    public String encode(List<String> strs) {
        List<Character> chars = new ArrayList<>();
        for (String str: strs) {
            // store the length and then the chars
            int l = str.length();
            chars.add('#');
            chars.add((char) l);
            for(char c: str.toCharArray()) {
                chars.add(c);
            }
        }
        String res = chars.stream().map(String::valueOf).collect(Collectors.joining());
        return res;
    }

    public List<String> decode(String str) {
        char[] chars = str.toCharArray();
        List<String> res = new ArrayList<>();
        int index = 0;
        while(index < chars.length){
            char c = chars[index];
            if (c == '#') {
                StringBuilder sb = new StringBuilder();
                index++;
                int l = chars[index];
                index++;
                for (int i = index; i < index + l; i++) {
                    sb.append(chars[i]);
                }
                index = index + l;
                res.add(sb.toString());
            }
        }
        return res;
    }
}
