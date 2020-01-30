package bubblesort;

import java.util.Arrays;

/**
 * @author kirit
 * @date 2020-1-29
 * 冒泡排序，时间复杂度为O(n²)
 */
public class BubbleSort {

    /**
     * 冒泡排序,初版
     */
    public void sort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 冒泡排序，2.0,增加了减少最外层的循环次数，若上一次已经有序，则不再继续循环
     */
    public void sort2(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 冒泡排序，3.0，在2.0的基础上，增加第二层循环遍历的优化，第二层冒泡排序只到上一层最后一次交换为止
     */
    public void sort3(int array[]) {
        //记录最后一次交换的位置
        int lastExchangeIndex = 0;
        //无序数列的边界，每次比较只需要到这里为止
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            //有序标记
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 鸡尾酒排序，在大部分元素已经有序的情况下，适合用鸡尾酒排序法
     */
    public void sort4(int array[]) {
        int temp = 0;
        for (int i = 0; i < array.length / 2; i++) {
            boolean isSorted = true;
            //先从左到右冒泡最大值
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }

            isSorted = true;
            //然后从右向左冒泡最小值
            for (int j = array.length - 1 - i; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }

    }


    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 4, 5, 6, 7, 8, 1, 28, 22, 45};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort3(array);
        System.out.println(Arrays.toString(array));
    }
}
