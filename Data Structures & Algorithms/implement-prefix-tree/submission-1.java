class PrefixTree {
    class TreeNode {
        boolean isWord;
        Map<Character, TreeNode> children;

        public TreeNode() {
            this.isWord = false;
            this.children = new HashMap<>();
        }
    }

    TreeNode root;

    public PrefixTree() {
         this.root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode curr = this.root;
        for (char c: word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TreeNode());
            }
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        TreeNode curr = this.root;
        for (char c: word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        TreeNode curr = this.root;
        for (char c: prefix.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return true;
    }
}
