class Node{
    int key = 0;
    int val = 0;
    Node next;
    Node prev;

    Node (){}

    Node(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    
    Map<Integer, Node> cache;
    int cap = 0;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public void insert(Node curr){
        Node temp = this.right.prev;
        curr.next = right;
        right.prev = curr;
        curr.prev = temp;
        temp.next = curr;
    }

    public void remove(Node curr){
        Node temp = curr.prev;
        Node temp1 = curr.next;
        temp1.prev = temp;
        temp.next = temp1;
    }

    public int get(int key) {
        if(this.cache.containsKey(key)){
            remove(this.cache.get(key));
            insert(this.cache.get(key));
            return this.cache.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }

        Node newNode = new Node(key,value);
        cache.put(key,newNode);
        insert(newNode);

        if(this.cache.size() > cap){
            Node first = this.left.next;
            remove(first);
            this.cache.remove(first.key);
        }
    }
}
