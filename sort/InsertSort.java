package sort;

/**
 * desc : 插入排序
 * date : 2018/3/28
 * 插入排序不是通过交换位置而是通过比较找到合适的位置插入元素来达到排序的目的的。
 * 相信大家都有过打扑克牌的经历，特别是牌数较大的。在分牌时可能要整理自己的牌，牌多的时候怎么整理呢？
 * 就是拿到一张牌，找到一个合适的位置插入。这个原理其实和插入排序是一样的。
 * 举个栗子，对5,3,8,6,4这个无序序列进行简单插入排序，首先假设第一个数的位置时正确的，
 * 想一下在拿到第一张牌的时候，没必要整理。然后3要插到5前面，把5后移一位，变成3,5,8,6,4.
 * 想一下整理牌的时候应该也是这样吧。然后8不用动，6插在8前面，8后移一位，4插在5前面，从5开始都向后移一位。
 * 注意在插入一个数的时候要保证这个数前面的数已经有序。
 * 特征 :
 * 稳定性 : 稳定
 * 时间复杂度 : O(n^2)
 * 辅助空间 : O(1)
 *
 * @author : dongSen
 */
public class InsertSort implements SortInterface {

    public static void main(String[] args) {

        int[] a = new int[]{3, 9, 1, 4, 5, 2};
//        sort(a);

        binaryInsertSort(a, 0, a.length - 1);

        for (int n : a) {
            System.out.println(n);
        }
    }

    @Override
    public void sort(int[] a) {
        binaryInsertSort(a, 0, a.length - 1);
    }

    private static void insertSort(int[] arr) {
        int temp, j;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            j = i;
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    private static int[] binaryInsertSort(int[] a, int left, int right) {
        int low, middle, high;
        int temp;
        for (int i = left + 1; i <= right; i++) {
            temp = a[i];
            low = left;
            high = i - 1;
            while (low <= high) {
                middle = (low + high) / 2;
                if (a[i] < a[middle])
                    high = middle - 1;
                else
                    low = middle + 1;
            }

            for (int j = i - 1; j >= low; j--)
                a[j + 1] = a[j];

            a[low] = temp;
        }

        return a;
    }
}
