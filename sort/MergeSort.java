package sort;


/**
 * desc : 归并排序
 * date : 2018/3/14
 * 归并排序是另一种不同的排序方法，因为归并排序使用了递归分治的思想，所以理解起来比较容易。
 * 其基本思想是，先递归划分子问题，然后合并结果。
 * 把待排序列看成由两个有序的子序列，然后合并两个子序列，然后把子序列看成由两个有序序列。。。。。
 * 倒着来看，其实就是先两两合并，然后四四合并。。。最终形成有序序列。
 * 特征 :
 * 稳定性 : 稳定
 * 时间复杂度 : O(nlogn)
 * 辅助空间 : O(n)
 *
 * @author : dongSen
 */
public class MergeSort implements SortInterface {

//    public static void main(String[] arg) {
//        int num = 15;
//        for (int i = num; i >= 1; i--) {
//            int count = i + i -1;
////            System.out.println(count);
//
//            StringBuilder builder = new StringBuilder();
//
//            for (int k = 0; k < num - i; k++) {
//                builder.append("   ");
//            }
//
//            for (int j = 0; j < count; j++) {
//                builder.append(" # ");
//            }
//
//            System.out.println(builder.toString());
//        }
//        System.out.println(6 & 1);
//        System.out.println(6 & 2);
//        System.out.println(6 & 3);
//    }


    @Override
    public void sort(int[] a) {
        mergeSort(a, 0, 1);
    }

    /**
     * 　*　<pre>
     * 　*　二路归并
     * 　*　原理：将两个有序表合并和一个有序表
     * 　*　</pre>
     * 　*
     * 　*　@param　a
     * 　*　@param　s
     * 　*　第一个有序表的起始下标
     * 　*　@param　m
     * 　*　第二个有序表的起始下标
     * 　*　@param　t
     * 　*　第二个有序表的结束小标
     * 　*
     */
    private static void merge(int[] a, int s, int m, int t) {
        int[] tmp = new int[t - s + 1];
        int i = s, j = m, k = 0;
        while (i < m && j <= t) {
            if (a[i] <= a[j]) {
                tmp[k] = a[i];
                k++;
                i++;
            } else {
                tmp[k] = a[j];
                j++;
                k++;
            }
        }
        while (i < m) {
            tmp[k] = a[i];
            i++;
            k++;
        }
        while (j <= t) {
            tmp[k] = a[j];
            j++;
            k++;
        }
        System.arraycopy(tmp, 0, a, s, tmp.length);
    }

    /**
     * @param a
     * @param s
     * @param len 每次归并的有序集合的长度
     */
    private static void mergeSort(int[] a, int s, int len) {
        int size = a.length;
        int mid = size / (len << 1);
        int c = size & ((len << 1) - 1);//集合有时候可能会剩余，c用来判断剩下那几个，比如7，分成2 2 集合，多1，
        //　-------归并到只剩一个有序集合的时候结束算法-------//
        if (mid == 0)
            return;
        //　------进行一趟归并排序-------//
        for (int i = 0; i < mid; ++i) {
            s = i * 2 * len;
            merge(a, s, s + len, (len << 1) + s - 1);
        }
        //　-------将剩下的数和倒数一个有序集合归并-------//
        if (c != 0)
            merge(a, size - c - 2 * len, size - c, size - 1);
        //　-------递归执行下一趟归并排序------//
        mergeSort(a, 0, 2 * len);
    }

    public static void main(String[] args) {
        //int[] a = new int[]{4, 3, 6, 1, 2, 5, 7};
//        int[] a = DataResource.getRandomInts(30, 100);
//        PrintUnit.printIntArray(a);
//        mergeSort(a, 0, 1);
//        for (int i = 0; i < a.length; ++i) {
//            System.out.print(a[i] + "　");
//        }
    }

}
