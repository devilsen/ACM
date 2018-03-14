public class Merge {

    /**
     * 对随机数组a进行归并排序
     *
     * @param a 待排序的随机数组
     *          return 排序好的数组
     */
    public static int[] mergeSort(int[] a) {
        //b 辅助排序队列
        int[] b = new int[a.length];
        mergeSort(a, 0, a.length - 1, b);
        return a;
    }

    /**
     * 对随机数组a进行归并排序
     *
     * @param a     待排序的随机数组
     * @param first 排序开始位置
     * @param last  排序结束位置
     * @param tmp   辅助排序空间
     */
    private static void mergeSort(int[] a, int first, int last, int[] tmp) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergeSort(a, first, mid, tmp);
            mergeSort(a, mid + 1, last, tmp);
            mergeArray(a, first, mid, last, tmp);
        }
    }

    /**
     * 合并两个随机数组
     *
     * @param a     待排序的随机数组
     * @param first 排序开始位置
     * @param mid   第一个数组结束的位置
     * @param last  排序结束位置
     * @param temp  辅助排序空间
     */
    private static void mergeArray(int a[], int first, int mid, int last, int temp[]) {
        int i = first, j = mid + 1;//两个数组开始的位置
        int m = mid, n = last; //两个数组结束的位置
        int k = 0;//辅助合并空间初始位置

        while (i <= m && j <= n) {
            if (a[i] <= a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }

        while (i <= m)
            temp[k++] = a[i++];

        while (j <= n)
            temp[k++] = a[j++];

        for (i = 0; i < k; i++)
            a[first + i] = temp[i];
    }

}