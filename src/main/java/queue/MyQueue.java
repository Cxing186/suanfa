package queue;

/**
 * @author kirit
 * @date 2019-11-16
 * 队列：逻辑上是先进先出的线性结构，队尾永远是空元素
 * 物理上可以是链表也可以是数组
 * 插入和删除的时间复杂度为O(1)
 */
public class MyQueue {
    /**
     * 数组实现队列
     */
    private int[] array;
    /**
     * 队头
     */
    private int font;
    /**
     * 队尾
     */
    private int rear;

    /**
     * 构造器初始化数组队列
     * @param size
     */
    public MyQueue(int size){
        this.array = new int[size];
    }

    /**
     * 入队
     * @param element
     * @throws Exception
     */
    public void enQueue(int element) throws Exception{
        if((rear+1)%array.length == font){
            throw new Exception("队列已满");
        }
        array[rear] = element;
        rear = (rear+1)%array.length;
    }

    /**
     * 出队
     * @return
     */
    public int outQueue() throws Exception{
        if(rear == font){
            throw new Exception("队列已空");
        }
        int element = array[font];
        font = (font+1)%array.length;
        return  element;
    }

    /**
     * 打印队列
     */
    public void output(){
        for (int i = font; i != rear; i=(i+1)%array.length) {
            System.out.print(array[i]+"-->");
        }
        System.out.println();
    }
}
