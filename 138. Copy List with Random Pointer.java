/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }

        Node temp=head;
        while(temp!=null){
            Node n=new Node(temp.val);
            Node tp1=temp.next;
            n.next=tp1;
            temp.next=n;
            temp=tp1;
        }

        Node t2=head;
        while(t2!=null){
            if(t2.random!=null){
                t2.next.random=t2.random.next;
            }
            t2=t2.next.next;
        }

        Node h2=head.next;
        Node n1=head;
        Node n2=head.next;
        while(n1!=null){
            Node n1p1=n1.next.next;
            Node n2p1=null;
            if(n2.next!=null){
                n2p1=n2.next.next;
            }
            n1.next=n1p1;
            n2.next=n2p1;
            n1=n1p1;
            n2=n2p1;
        }
        return h2;
    }
}
