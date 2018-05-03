package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * desc : 桶排序
 * date : 2018/4/3
 * 桶排序算是计数排序的一种改进和推广，但是网上有许多资料把计数排序和桶排序混为一谈。其实桶排序要比计数排序复杂许多。
 * 假设有一组长度为N的待排关键字序列K[1....n]。首先将这个序列划分成M个的子区间(桶) 。
 * 然后基于某种映射函数 ，将待排序列的关键字k映射到第i个桶中(即桶数组B的下标 i) ，
 * 那么该关键字k就作为B[i]中的元素(每个桶B[i]都是一组大小为N/M的序列)。
 * 接着对每个桶B[i]中的所有元素进行比较排序(可以使用快排)。然后依次枚举输出B[0]….B[M]中的全部内容即是一个有序序列。
 * bindex=f(key) 其中，bindex 为桶数组B的下标(即第bindex个桶), k为待排序列的关键字。
 * 桶排序之所以能够高效，其关键在于这个映射函数，它必须做到：如果关键字k1<k2，那么f(k1)<=f(k2)。
 * 也就是说B(i)中的最小数据都要大于B(i-1)中最大数据。很显然，映射函数的确定与数据本身的特点有很大的关系。
 * 特征 :
 * 稳定性 : 稳定
 * 时间复杂度 : 对于N个待排数据，M个桶，平均每个桶[N/M]个数据的桶排序平均时间复杂度为：O(N)+O(M*(N/M)*log(N/M))=O(N+N*(logN-logM))=O(N+N*logN-N*logM)
 * 辅助空间 :
 *
 * @author : dongSen
 */
public class BucketSort implements SortInterface {
    public static void main(String[] args) {
        int[] input = {80, 50, 30, 10, 90, 60, 0, 70, 40, 20, 50};

        System.out.println(Arrays.toString(input));

        bucketsort(input);

        System.out.println(Arrays.toString(input));
    }

    @Override
    public void sort(int[] a) {
        bucketsort(a);
    }

    private static int[] bucketsort(int[] input) {
        final int[] code = hash(input);
        //创建桶
        List<Integer>[] buckets = new List[code[1]];
        for (int i = 0; i < code[1]; i++) {
            buckets[i] = new ArrayList<>();
        }
        //放入桶中
        for (int i : input) {
            buckets[hash(i, code)].add(i);
        }

        for (List bucket : buckets) {
            Collections.sort(bucket);
        }
        int ndx = 0;
        //合并
        for (List<Integer> bucket : buckets) {
            for (int v : bucket) {
                input[ndx++] = v;
            }
        }
        return input;
    }

    private static int[] hash(int[] input) {
        int m = input[0];
        for (int i = 1; i < input.length; i++) {
            if (m < input[i]) {
                m = input[i];
            }
        }
        return new int[]{m, (int) Math.sqrt(input.length)};
    }

    private static int hash(int i, int[] code) {
        return (int) ((double) i / code[0] * (code[1] - 1));
    }

}