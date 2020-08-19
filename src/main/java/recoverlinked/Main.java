package recoverlinked;

/**
 * @author tmz
 * @since 08/18
 * @version 1.0
 * <p>单向链表进行反单向链表</p>
 */
public class Main {
    public static void main(String[] args) {
        Node node = new Node();
        node.setData(1);
        node.setNext(new Node(2,new Node(3,null)));
        node.print();
        recover(node).print();
    }
    /**
     * @author tmz
     * @description
     * @date 8:49 2020/8/19
     * @param node
     * @return recoverlinked.Node
     */
    private static Node recover(Node node){
        if (node==null||null==node.getNext()){
            return node;
        }
        Node pre =null;
        Node curr=node;
        Node next=null;
        while (null!=curr.getNext()){
            next = curr.getNext();
            curr.setNext(pre);//将前置节点被当前指针next选中
            pre = curr;//前置指针移动到当前节点
            curr = next;//下一个
        }
        return curr;
    }
}
