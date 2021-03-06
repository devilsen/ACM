package sort;

import java.util.Arrays;

/**
 * desc : 堆排序
 * date : 2018/4/3
 * 特征 :
 * 稳定性 : 不稳定
 * 时间复杂度 : O(nlgn)
 * 辅助空间 : O(1)
 *
 * @author : dongSen
 */
public class HeapSort implements SortInterface {

    public static void main(String args[]) {
        int[] arr = {7, 8, 9, 4, 5, 6, 3, 2, 1};

        System.out.println(Arrays.toString(arr));

        heap(arr);

        System.out.println(Arrays.toString(arr));
    }

    @Override
    public void sort(int[] a) {
        heap(a);
    }

    static void heapify(int a[], int n, int i) {
        int max, child;
        child = 2 * i + 1;
        max = i;
        if (child < n)
            if (a[child] > a[max])
                max = child;
        if (child + 1 < n)
            if (a[child + 1] > a[max])
                max = child + 1;
        if (max != i) {
            int temp = a[i];
            a[i] = a[max];
            a[max] = temp;
            heapify(a, n, max);
        }

    }

    static void buildheap(int a[]) {
        for (int i = a.length / 2 - 1; i >= 0; i--)
            heapify(a, a.length, i);
    }

    static int[] heap(int a[]) {
        buildheap(a);
        for (int i = a.length - 1; i >= 1; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapify(a, i, 0);
        }
        return a;
    }

}
