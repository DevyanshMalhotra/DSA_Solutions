class Node{
    Node next;
    Node prev;
    int key;
    int val;
    public Node(){

    }
}

class LRUCache {
    HashMap<Integer,Node> hm;
    Node H=new Node();
    Node T=new Node();
    int cap;
    public LRUCache(int capacity) {
        hm=new HashMap<>();
        H.next=T;
        T.prev=H;
        cap=capacity;

    }

    public Node delete(Node h, Node del){
        Node dp1=del.next;
        Node dm1=del.prev;
        dp1.prev=dm1;
        dm1.next=dp1;
        del.prev=null;
        del.next=null;
        return del;
    }
    
    public void add(Node h, Node t, Node n){
        Node tm1=t.prev;
        tm1.next=n;
        n.prev=tm1;
        n.next=t;
        t.prev=n;
    }

    public int get(int key) {
        if(hm.get(key)==null){
            return -1;
        }else{
            int ans=hm.get(key).val;
            Node temp=delete(H,hm.get(key));
            add(H,T,temp);
            return ans;
        }
    }
    
    public void put(int key, int value) {
        Node temp=hm.get(key);

        if(temp==null){
            if(hm.size()==cap){
                hm.remove(H.next.key);
                delete(H,H.next);
            }
            Node n=new Node();
            n.key=key;
            n.val=value;
            hm.put(key,n);
            add(H,T,n);
        }else{
            Node t=delete(H,temp);
            t.val=value;
            add(H,T,temp);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
