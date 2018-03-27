package me.devilsen.test.week_3;

/**
 * @author dongsen
 *         date: 2018/03/27 0027.
 *         1.找数组中的特定元素。问题描述：一个int数组，里面数据无任何限制，要求求出所有这样的数a[i]，其左边的数都小于等于它，右边的数都大于等于它。能否只用一个额外数组和少量其它空间实现。

 */

public class FindNum {

    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 4, 5};

        for (int i = 1; i < a.length - 1; i++) {
            if (checkLeft(a, a[i], i) && checkRight(a, a[i], i)) {
                System.out.println(a[i]);
            }

        }
    }

    private static boolean checkRight(int[] a, int num, int i) {
        for (int j = i; j < a.length; j++) {
            if (a[j] < num) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkLeft(int[] a, int num, int i) {
        for (int j = 0; j < i; j++) {
            if (a[j] > num) {
                return false;
            }
        }
        return true;
    }

}
