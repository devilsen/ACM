package sort;


import java.util.Arrays;

/**
 * desc : 希尔排序
 * date : 2018/3/28
 * 希尔排序是插入排序的一种高效率的实现，也叫缩小增量排序。简单的插入排序中，如果待排序列是正序时，时间复杂度是O(n)，
 * 如果序列是基本有序的，使用直接插入排序效率就非常高。希尔排序就利用了这个特点。
 * 基本思想是：先将整个待排记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录基本有序时再对全体记录进行一次直接插入排序
 * 特征 :
 * 稳定性 : 不稳定
 * 时间复杂度 : O(nlgn)
 * 辅助空间 : O(1)
 *
 * @author : dongSen
 */
public class ShellSort implements SortInterface {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 7, 9, 8, 3, 6};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {1, 4, 2, 7, 9, 8, 3, 6};
        sort1(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    @Override
    public void sort(int[] a) {
        shellSort(a);
    }

    /**
     * 希尔排序 针对有序序列在插入时采用交换法
     *
     * @param arr
     */
    private static void shellSort(int[] arr) {
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j - gap >= 0 && arr[j] < arr[j - gap]) {
                    //插入排序采用交换法
                    swap(arr, j, j - gap);
                    j -= gap;
                }
            }
        }
    }

    /**
     * 希尔排序 针对有序序列在插入时采用移动法。
     *
     * @param arr
     */
    private static void sort1(int[] arr) {
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动法
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 交换数组元素
     *
     * @param arr
     * @param a
     * @param b
     */
    private static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

}