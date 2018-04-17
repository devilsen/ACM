package me.devilsen.test.week_5;

import java.util.Arrays;

/**
 * @author dongsen
 *         date: 2018/04/17 0017.
 *         <p>
 *         2b + a + d
 *         2a + c + d
 *         2b-c-a
 */

public class CrossRiver {

    public static void main(String[] args) {
        int[] a = {3, 5, 1, 4};

        int total = cross(a);

        System.out.println(total);
    }

    private static int cross(int a[]) {
        Arrays.sort(a);

        int total = 0;

        int length = a.length - 1;

        while (a.length > 0) {
            if (a.length == 1) {
                total += a[0];
            } else if (a.length == 2) {
                total += a[1];
            } else if (a.length == 3) {
                total += a[0] + a[1] + a[2];
            } else {
                if (2 * a[1] - a[length - 1] - a[0] > 0) {
                    total += 2 * a[0] + a[length] + a[length - 1];//2a+c+d
                } else {
                    total += 2 * a[1] + a[0] + a[length];//2b + a + d
                }
            }

            if (a.length == 1 || a.length == 2 || a.length == 3)
                break;

            a = Arrays.copyOfRange(a, 0, length - 1);

            System.out.println("aa  " + a.length);

        }

        return total;
    }

}
