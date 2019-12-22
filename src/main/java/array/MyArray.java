package array;

/**
 * @author kirit
 * @date 2019-11-10
 * 数组：在内存中顺序存储，可以很好的实现逻辑上的顺序表
 *  1，数组插入和删除的时间复杂度为O(n)
 *  2, 查询和修改的时间复杂度为O(1)
 *  所以 数组比较适合 “读多写少” 的场景
 */
public class MyArray {
    /**
     * 数组，在内存中是连续顺序存储的
     */
    private int[] array;
    /**
     * 实际的元素个数
     */
    private int size;

    /**
     * 构造器，创建一个指定大小的数组
     * size默认为0个元素
     * @param capacity
     */
    public MyArray(int capacity) {
        this.array = new int[capacity];
        size = 0;
    }

    /**
     * 往数组的指定位置插入指定数值
     *
     * @param index   插入的位置
     * @param element 插入的元素
     * @throws Exception
     */
    public void insert(int index, int element) throws Exception {
         //1，检查下标是否超出范围
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围！");
        }
         //2，如果实际长度超过或者等于数组的长度，则扩大数组长度
        if (size >= array.length) {
            resize();
        }
         //3,从右向左，将元素依次向右挪动一位
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    /**
     * 删除指定位置的元素
     * @param index 元素下标位置
     */
    public int delete(int index) {
        //1，检查下标是否超出范围
        if (index <= 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围！");
        }
        int deletElement = array[index];
         //2，从左向右循环，将元素逐个向左挪动一位
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        array[size] = 0;
        return deletElement;
    }

    /**
     * 数组扩容
     */
    public void resize() {
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    /**
     * 打印数组元素
     */
    public void output() {
        for (int i : array) {
            System.out.print(i + "||");
        }
    }

}
