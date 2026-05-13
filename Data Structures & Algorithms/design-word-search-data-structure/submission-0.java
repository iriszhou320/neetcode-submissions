class WordDictionary {

    class Node {
        boolean isWord;
        Map<Character, Node> children;

        public Node() {
            this.isWord = false;
            this.children = new HashMap<>();
        }
    }

    Node root;

    public WordDictionary() {
       this.root = new Node();
    }

    public void addWord(String word) {
        Node curr = this.root;
        for (char c: word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new Node());
            }

            curr = curr.children.get(c);
        }

        curr.isWord = true;
    }

    // DFS
    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(Node root, String word, int start) {
        if (start == word.length()) return root.isWord;
        if (word.charAt(start) == '.') {
            for (Map.Entry<Character, Node> entry: root.children.entrySet()) {
                if (dfs(entry.getValue(), word, start+1)) {
                    return true;
                }
            }
            return false;
        } else {
            Node child = root.children.get(word.charAt(start));
            return child != null && dfs(child, word, start+1);
        }
    }
}
