package queue;

/**
 * @author kirit
 * @date 2019-11-16
 *
 */
public class QueueTest {
    public static void main(String[] args) throws Exception{
        MyQueue myQueue = new MyQueue(5);
        myQueue.enQueue(0);
        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);
        myQueue.output();
        myQueue.outQueue();
        myQueue.output();
    }
}
