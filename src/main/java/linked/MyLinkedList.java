package linked;

/**
 * @author kirit
 * @date 2019-11-10
 * 链表：在物理上非连续，非顺序的数据结构，由若干节点所组成
 * 1，链表的查询时间复杂度为O(n)
 * 2，不考虑链表的查询，链表的修改，增加，删除的时间复杂度都为O(1)
 *  所以链表比较适合在 尾部，头部频繁插入，删除 的场景
 */
public class MyLinkedList {
    /**
     * 链表头节点
     */
    private Node head;

    /**
     * 链表尾节点
     */
    private Node last;

    /**
     * 链表的长度
     */
    private int size;

    /**
     * 链表插入
     *
     * @param data
     * @param index
     * @throws Exception
     */
    public void insert(int data, int index) throws Exception {
        //1，检查插入链表的范围
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node insertNode = new Node(data);
        if (size == 0) {
            //空链表
            head = insertNode;
            last = insertNode;
        } else if (index == 0) {
            //插入头部
            insertNode.setNext(head);
            head = insertNode;
        } else if (index == size) {
            //插入尾部
            last.setNext(insertNode);
            last = insertNode;
        } else {
            //插入中间
            Node temp = get(index - 1);
            insertNode.setNext(temp.getNext());
            temp.setNext(insertNode);
        }
        size++;
    }

    /**
     * 查找链表元素
     *
     * @param index
     * @return
     * @throws Exception
     */
    public Node get(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表的节点范围");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    /**
     * 删除指定位置元素
     *
     * @param index
     * @return
     * @throws Exception
     */
    public Node remove(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表的节点范围");
        }
        Node removeNode = null;
        if (index == 0) {
            //删除头节点
            removeNode = head;
            head = head.getNext();
        } else if (index == size - 1) {
            //删除尾节点
            last = get(index - 1);
            removeNode = last.getNext();
            last.setNext(null);
        } else {
            //删除中间节点
            Node tempNode = get(index - 1);
            removeNode = tempNode.getNext();
            tempNode.setNext(removeNode.getNext());
        }
        size--;
        return removeNode;
    }

    /**
     * 输出节点
     */
    public void output() {
        Node tempNode = head;
        while (tempNode != null) {
            System.out.print("-->" + tempNode.getData());
            tempNode = tempNode.getNext();
        }
    }
}
