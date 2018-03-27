package me.devilsen.test.week_3;

/**
 * @author dongsen
 *         date: 2018/03/27 0027.
 *         <p>
 *         2.寻找捣乱分子对。问题描述：多人排成一个队列，我们认为从低到高是正确的序列，但是总有部分人不遵守秩序。如果说，前面的人比后面的人高(两人身高一样认为是合适的)，
 *         那么我们就认为这两个人是一对“捣乱分子”，比如说,现在存在一个序列:176, 178, 180, 170, 171
 *         这些捣乱分子对为<176, 170>, <176, 171>, <178, 170>, <178, 171>, <180, 170>, <180, 171>，
 *         那么，现在给出一个整型序列，请找出这些捣乱分子对的个数(仅给出捣乱分子对的数目即可，不用具体的对)
 */

public class FindWrongNum {

    public static void main(String[] args) {
        int[] a = new int[]{176, 178, 180, 170, 171};

        for (int i = 0; i < a.length; i++) {
            compare(a[i], a, i);
        }
    }

    private static void compare(int num, int[] a, int i) {
        for (int j = i; j < a.length; j++) {
            if (num > a[j]) {
                System.out.println(num + "  " + a[j]);
            }
        }
    }

}
