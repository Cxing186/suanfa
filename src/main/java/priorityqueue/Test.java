package priorityqueue;

/**
 * @author kirit
 * @date 2020-1-28
 */
public class Test {
    public static void main(String[] args) throws Exception{
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enQueue(1);
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(6);
        priorityQueue.enQueue(5);
        System.out.println(priorityQueue.toString());
        priorityQueue.delQueue();
        System.out.println(priorityQueue.toString());
    }
}
