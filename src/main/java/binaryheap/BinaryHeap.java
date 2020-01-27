package binaryheap;


import java.util.Arrays;

/**
 * @author kirit
 * @date 2020-1-27
 * 二叉堆：二叉堆的物理存储方式为顺序存储，即为数组的形式存在内存中
 * 假设父节点的下标是prarent那么其左孩子的下标是2*parent+1,右孩子的下标是2*parent+2
 */
public class BinaryHeap {

    public int[] array;

    public int[] binaryHeap;

    public BinaryHeap(int[] array) {
        this.array = array;
        this.binaryHeap = Arrays.copyOf(array, array.length);
    }

    /**
     * 构建堆
     */
    public int[] buildBinaryHeap() {
        //从最后一个父节点（a）开始，做下沉工作
        for (int i = ((array.length - 1) - 1) / 2; i >= 0; i--) {
            downAdjust(i);
        }
        return binaryHeap;
    }

    /**
     * 上浮调整
     */
    public void upAdjust() {
        //最后一个叶子节点的下标
        int childIndex = binaryHeap.length - 1;
        //父节点
        int parentIndex = (childIndex - 1) / 2;
        //当孩子节点值小于父节点时，节点上浮
        while (childIndex > 0 && binaryHeap[childIndex] < binaryHeap[parentIndex]) {
            int temp = binaryHeap[parentIndex];
            binaryHeap[parentIndex] = binaryHeap[childIndex];
            binaryHeap[childIndex] = temp;
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
    }

    /**
     * 要下沉的父节点的下标
     *
     * @param index
     */
    public void downAdjust(int index) {
        int lenght = binaryHeap.length;
        //左孩子节点
        int leftChildIndex = index * 2 + 1;
        int rightChildIndex = index * 2 + 2;
        //下标为左右孩子节点中值小的那个下标
        int childIndex = rightChildIndex >= lenght ? leftChildIndex : binaryHeap[leftChildIndex] < binaryHeap[rightChildIndex] ? leftChildIndex : rightChildIndex;
        //当父节点的值大于孩子节点时，节点下沉
        while (childIndex < binaryHeap.length && binaryHeap[index] > binaryHeap[childIndex]) {
            int temp = binaryHeap[index];
            binaryHeap[index] = binaryHeap[childIndex];
            binaryHeap[childIndex] = temp;
            index = childIndex;
            leftChildIndex = index * 2 + 1;
            rightChildIndex = index * 2 + 2;
            if (leftChildIndex >= lenght ) {
                break;
            }
            childIndex = rightChildIndex >= lenght ? leftChildIndex : binaryHeap[leftChildIndex] < binaryHeap[rightChildIndex] ? leftChildIndex : rightChildIndex;
        }
    }


}
