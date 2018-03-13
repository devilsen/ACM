package me.devilsen.test.week_1;

/**
 * Created by dongsen on 2018/03/13 0013.
 *
 * @author dongsen
 */

public class NarcissisticNumber {

    public static void main(String[] arg) {
        for (int i = 100; i < 1000; i++) {
            int a = (int) Math.pow(getHundred(i), 3);
            int b = (int) Math.pow(getTen(i), 3);
            int c = (int) Math.pow(getSingle(i), 3);

            if (i == a + b + c) {
                System.out.println(i);
            }
        }
    }

    private static int getHundred(int num) {
        return num / 100;
    }

    private static int getTen(int num) {
        return num % 100 / 10;
    }

    private static int getSingle(int num) {
        return num % 10;
    }

}
