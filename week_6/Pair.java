package me.devilsen.test.week_6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author dongsen
 * date: 2018/05/16 0016.
 * <p>
 * 描述
 * 现在，有一行括号序列，请你检查这行括号是否配对。
 * 输入
 * 第一行输入一个数N（0<N<=100）,表示有N组测试数据。后面的N行输入多组输入数据，每组输入数据都是一个字符串S(S的长度小于10000，且S不是空串），测试数据组数少于5组。数据保证S中只含有"[","]","(",")"四种字符
 * 输出
 * 每组输入数据的输出占一行，如果该字符串中所含的括号是配对的，则输出Yes,如果不配对则输出No
 * 样例输入：
 * 3
 * [(])
 * (])
 * ([[]()])
 * 样例输出：
 * No
 * No
 * Yes
 */
public class Pair {

    private static Scanner scanner;

    private static ArrayList<String> lines = new ArrayList<>(5);

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        input(times);

        for (int i = 0; i < times; i++) {
            if (check(lines.get(i))) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }

    }

    private static void input(int times) {
        scanner.nextLine();

        for (int i = 0; i < times; i++) {
            String s = scanner.nextLine();
            lines.add(s);
        }
    }

    private static boolean check(String text) {
        int length = text.length();

        if (length % 2 != 0) {
            return false;
        }

        LinkedList<Character> list = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);

            if ('(' == c || '[' == c) {
                list.add(c);
            } else {
                Character character = list.pollLast();
                if (('[' == character && c == ']') || ('(' == character && c == ')')) {
                } else {
                    return false;
                }
            }

        }

        return list.size() == 0;
    }

}
