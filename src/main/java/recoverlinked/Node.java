package recoverlinked;

import lombok.Data;


public class Node {
    Object data;
    Node next;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node() {
    }
    public void print(){
        Node cur=this;
        while(cur!=null){
            System.out.println(cur.toString());
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
