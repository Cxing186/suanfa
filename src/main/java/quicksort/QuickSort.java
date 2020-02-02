package quicksort;

import java.util.Arrays;

/**
 * @author kirit
 * @date 2020-2-1
 * 快速排序
 * 1，双边循环法
 * 2，单边循环法
 */
public class QuickSort {

    /**
     * 递归方式实现
     */
    public void sort(int[] array, int startIndex, int endIndex) {
        //递归循环介绍条件
        if (startIndex >= endIndex) {
            return;
        }
        //得到每轮替换后基准元素的位置,双边循环法
        //int pivotIndex = sort1Partition(array, startIndex, endIndex);
        //单边循环法
        int pivotIndex = sort2Partition(array, startIndex, endIndex);
        //原数组根据基准元素位置切分为两半,然后再分别排序，前半段
        sort(array, startIndex, pivotIndex - 1);
        //后半段
        sort(array, pivotIndex + 1, endIndex);
    }

    /**
     * 双边循环法
     */
    public int sort1Partition(int[] array, int startIndex, int endIndex) {
        //以第一个元素作为基准元素
        int pivot = array[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            //右指针左移，条件：右指针元素比基准元素大，并且右指针大于左指针
            while (array[right] > pivot && left < right) {
                right--;
            }
            //左指针右移，条件：左指针元素比基准元素小，并且左指针小于右指针
            while (array[left] <= pivot && left < right) {
                left++;
            }
            //当左指针停止右移，右指针停止左移时，交换左右指针的元素值，条件：左指针小于右指针，防止死循环
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        //左右指针重合后，替换指针指向的值和基准元素值
        array[startIndex] = array[left];
        array[left] = pivot;
        return left;
    }

    /**
     * 单边循环法,只有左指针
     */
    public int sort2Partition(int[] array, int startIndex, int endIndex) {
        //基准值pivot
        int pivot = array[startIndex];
        int mark = startIndex;
        //每当有元素小于基准值时，交换值，mark++
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (array[i] <= pivot) {
                mark++;
                int temp = array[mark];
                array[mark] = array[i];
                array[i] = temp;
            }
        }
        array[startIndex] = array[mark];
        array[mark] = pivot;
        return mark;
    }


    public static void main(String[] args) {
        int[] array = new int[]{4,4,6,5,3,2,8,1};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
