package sort;


/**
 * desc : 快速排序
 * date : 2018/3/21
 * 快速排序一听名字就觉得很高端，在实际应用当中快速排序确实也是表现最好的排序算法。冒泡排序虽然高端，但其实其思想是来自冒泡排序，冒泡排序是通过相邻元素的比较和交换把最小的冒泡到最顶端，而快速排序是比较和交换小数和大数，这样一来不仅把小数冒泡到上面同时也把大数沉到下面。
 * <p>
 * 举个栗子：对5,3,8,6,4这个无序序列进行快速排序，思路是右指针找比基准数小的，左指针找比基准数大的，交换之。
 * 5,3,8,6,4 用5作为比较的基准，最终会把5小的移动到5的左边，比5大的移动到5的右边。
 * 5,3,8,6,4 首先设置i,j两个指针分别指向两端，j指针先扫描（思考一下为什么？）4比5小停止。然后i扫描，8比5大停止。交换i,j位置。
 * 5,3,4,6,8 然后j指针再扫描，这时j扫描4时两指针相遇。停止。然后交换4和基准数。
 * 4,3,5,6,8 一次划分后达到了左边比5小，右边比5大的目的。之后对左右子序列递归排序，最终得到有序序列。
 * 上面留下来了一个问题为什么一定要j指针先动呢？首先这也不是绝对的，这取决于基准数的位置，因为在最后两个指针相遇的时候，要交换基准数到相遇的位置。一般选取第一个数作为基准数，那么就是在左边，所以最后相遇的数要和基准数交换，那么相遇的数一定要比基准数小。所以j指针先移动才能先找到比基准数小的数。
 * 特征 :
 * 稳定性 : 不稳定
 * 时间复杂度 : O(n*lgn) 最坏O(n^2)
 * 辅助空间 : O(lgn)
 *
 * @author : dongSen
 */
public class QuickSort implements SortInterface {

    public static void main(String[] args) {
        int[] a = {7, 10, 3, 5, 4, 6, 2, 8, 1, 9};
        quickSort(a, 1, 10);
        for (int anA : a)
            System.out.print(anA + " ");
    }

    @Override
    public void sort(int[] a) {
        quickSort(a, 1, a.length);
    }

    private static int Partition(int[] a, int p, int r) {
        int x = a[r - 1];
        int i = p - 1;
        int temp;
        for (int j = p; j <= r - 1; j++) {
            if (a[j - 1] <= x) {
                // 交换(a[j-1],a[i]);
                temp = a[j - 1];
                a[j - 1] = a[i];
                a[i] = temp;
                i++;
            }
        }
        //交换(a[r-1],a[i]);
        temp = a[r - 1];
        a[r - 1] = a[i];
        a[i] = temp;
        return i + 1;
    }

    private static void quickSort(int[] a, int p, int r) {
        if (p < r) {
            int q = Partition(a, p, r);
            quickSort(a, p, q - 1);
            quickSort(a, q + 1, r);
        }
    }

}
