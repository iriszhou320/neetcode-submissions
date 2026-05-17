class LRUCache {
    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    int capacity;
    Map<Integer, Node> map;
    Node head = new Node(0);
    Node tail = new Node(0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        } 
        return -1;
    }
    
    public void put(int key, int value) {
        Node node;
        if (this.map.containsKey(key)) {
            node = this.map.get(key);
            remove(node);
            node.val = value;
            insert(node);
        } else {
            if (this.map.size() == capacity) {
                // remove head
                System.out.println("remove in put head: " + head.val);
                remove(head.next);
                insert(new Node(key, value));
            } else {
                insert(new Node(key, value));
            }
        }
    }

    private void remove(Node node) {
        // remove from the map
        // remove the node
        this.map.remove(node.key, node);
        if (node == head) {
            System.out.println("remove head: " + node.val);
            Node temp = head.next;
            temp.prev = null;
            head = temp;
        } else {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            System.out.println("remove: " + node.val);
            next.prev = prev;
        }
    }

    private void insert(Node node) {
        // insert to the map
        // add to the back of the list
        this.map.put(node.key, node);
        System.out.println("insert: " + node.val);
        Node temp = tail.prev;
        temp.next = node;
        node.prev = temp;
        node.next = tail;
        tail.prev = node;
    }
}
