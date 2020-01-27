package binaryheap;

import java.util.Arrays;

/**
 * @author kirit
 * @date 2020-1-27
 */
public class HeapTest {
    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap(new int[]{1,3,2,6,5,7,8,9,10,0});
        //上浮调整，最后一个上浮
        binaryHeap.upAdjust();
        System.out.println(Arrays.toString(binaryHeap.array));
        System.out.println(Arrays.toString(binaryHeap.binaryHeap));

        BinaryHeap binaryHeap1 = new BinaryHeap(new int[]{7,1,3,10,5,2,8,9,6});
        System.out.println(Arrays.toString(binaryHeap1.buildBinaryHeap()));

    }
}
