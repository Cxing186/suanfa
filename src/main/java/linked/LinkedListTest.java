package linked;

/**
 * @author kirit
 * @date 2019-11-10
 * 链表
 */
public class LinkedListTest {
    public static void main(String[] args) throws Exception {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert(0, 0);
        myLinkedList.insert(1, 1);
        myLinkedList.insert(2, 2);
        myLinkedList.insert(3, 3);
        myLinkedList.insert(4, 4);
        myLinkedList.insert(5, 5);
        myLinkedList.insert(22, 2);
        Node removeNode = myLinkedList.remove(0);
        System.out.println("删除的节点为：" + removeNode.getData());
        myLinkedList.output();
    }
}
