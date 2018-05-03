package sort;

import java.util.Arrays;
import java.util.HashMap;

/**
 * desc :
 * date : 2018/4/18
 *
 * @author : dongSen
 */
public class Sort {

    private HashMap<String, SortInterface> map = new HashMap<>();

    public static void main(String[] args) {

        int[] a = {12, 4, 2, 55, 12, 89, 82};

        Sort sort = new Sort();

        sort.sortArray(a);

        System.out.println(Arrays.toString(a));
    }

    private Sort() {
        map.put("BubbleSort", new BubbleSort());
        map.put("SelectSort", new SelectSort());
        map.put("CountingSort", new CountingSort());
        map.put("BucketSort", new BucketSort());
        map.put("HeapSort", new HeapSort());
        map.put("InsertSort", new InsertSort());
        map.put("MergeSort", new MergeSort());
        map.put("QuickSort", new QuickSort());
        map.put("ShellSort", new ShellSort());
    }

    private void sortArray(int[] a) {
        long start = System.currentTimeMillis();

        map.get("ShellSort").sort(a);

        long end = System.currentTimeMillis();

        System.out.println("time:  " + (end - start));

    }


}
