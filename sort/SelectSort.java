package sort;

import java.util.Arrays;

/**
 * desc : 选择排序
 * date : 2018/4/3
 * 选择排序的思想其实和冒泡排序有点类似，都是在一次排序后把最小的元素放到最前面。
 * 但是过程不同，冒泡排序是通过相邻的比较和交换。而选择排序是通过对整体的选择。
 * 举个栗子，对5,3,8,6,4这个无序序列进行简单选择排序，首先要选择5以外的最小数来和5交换，也就是选择3和5交换，
 * 一次排序后就变成了3,5,8,6,4.对剩下的序列一次进行选择和交换，最终就会得到一个有序序列。
 * 其实选择排序可以看成冒泡排序的优化，因为其目的相同，只是选择排序只有在确定了最小数的前提下才进行交换，大大减少了交换的次数。
 * 特征 :
 * 稳定性 : 不稳定
 * 时间复杂度 : O(n^2)
 * 辅助空间 : O(1)
 *
 * @author : dongSen
 */
public class SelectSort implements SortInterface {

    private static void selectSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        int minIndex;

        for (int i = 0; i < arr.length - 1; i++) { //只需要比较n-1次
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) { //从i+1开始比较，因为minIndex默认为i了，i就没必要比了。
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) { //如果minIndex不为i，说明找到了更小的值，交换之。
                swap(arr, i, minIndex);
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {44, 1, 29, 59};
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }

    @Override
    public void sort(int[] a) {
        selectSort(a);
    }
}
