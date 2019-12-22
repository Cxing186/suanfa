package linked;

/**
 * @author kirit
 * @date 2019-11-10
 * 单向链表的每一个节点由数据和指向下一链表的指针组成
 */
public class Node {
    /**
     * 数据
     */
    private int data;
    /**
     * 指针
     */
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}