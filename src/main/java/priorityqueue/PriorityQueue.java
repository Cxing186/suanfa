package priorityqueue;

import java.util.Arrays;

/**
 * @author kirit
 * @date 2020-1-28
 * 优先队列：利用二叉堆中的最小堆，最大堆原理实现最小，最大优先队列
 */
public class PriorityQueue {
    //以物理储存为数组形式实现优先队列
    private int[] array;
    //优先队列的实际长度
    private int size;

    /**
     * 构造器，默认队列数组的大小为32位
     */
    public PriorityQueue() {
        array = new int[32];
    }

    /**
     * 扩容，数组长度扩大一倍
     */
    public void resize() {
        int newSize = this.size * 2;
        this.array = Arrays.copyOf(this.array, newSize);
    }

    /**
     * 入队
     *
     * @param value
     */
    public void enQueue(int value) {
        //数组已经达到最大长度，扩容
        if(size >= array.length){
            resize();
        }
        //先用，再加
        array[size++]=value;
        //对加入队列的元素上浮
        upAdjust();
    }

    /**
     * 出队
     * @return
     */
    public int delQueue() throws  Exception{
        if(size <= 0){
            throw  new Exception("the queue is Empty");
        }
        int head = array[0];
        //先减，再用，最后一位挪到队列头部
        array[0] = array[--size];
        array[size] = 0;
        //对队头做下沉操作
        downAdjust();
        return head;
    }

    /**
     * 上浮
     */
    private void upAdjust() {
        int childIndex = size - 1;
        int parentIndex = (childIndex - 1) / 2;
        //临时保存新增的孩子节点的值
        int temp = array[childIndex];
        //当孩子节点还能往上移，并且孩子节点值要比父节点大时，交换孩子节点与父亲节点的值
        while (childIndex > 0 && temp > array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    /**
     * 下沉
     */
    private void downAdjust() {
        //优先队列优先出队的是第一个元素
        int parentIndex = 0;
        int temp = array[parentIndex];
        //左孩子
        int childIndex = 1;
        while (childIndex < size) {
            //如果有右孩子，切右孩子的值大于左孩子，则定位到右孩子
            if ((childIndex + 1) < size && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            //如果父节点大于最大的孩子，则跳出循环
            if (temp > array[childIndex]) {
                break;
            }
            //否则交换值，并父节点下移
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
        array[parentIndex] = temp;
    }

    @Override
    public String toString() {
        return "PriorityQueue{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }
}
