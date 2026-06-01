class LRUCache {
    private int capacity;
    private HashMap<Integer,Node> ca;
    private Node left;
    private Node right;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.ca= new HashMap<>();
        this.left= new Node(0,0);
        this.right = new Node(0,0);
        this.left.next= this.right;
        this.right.prev = this.left;
    }
    
    public int get(int key) {
        if(ca.containsKey(key)){
              Node node = ca.get(key);
            remove(node);
            add(node);
            return node.val;
        }
        return -1;
    }
    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next=next;
        next.prev=prev;
    }

    public void add(Node node){
        Node r =this.right.prev;
        r.next=node;
        node.prev=r;
        node.next=this.right;
        this.right.prev=node;

    }
    
    public void put(int key, int value) {

        if(ca.containsKey(key)){
            remove(ca.get(key));
        }

        Node n = new Node(key,value);
        ca.put(key,n);
        add(n);
        if(ca.size()>capacity){
             Node lru = this.left.next;
            remove(lru);
            ca.remove(lru.key);
        }
        
    }
}

public class Node{
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key=key;
        this.val=val;
        this.prev=null;
        this.next = null;
    }
}
