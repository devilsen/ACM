package me.devilsen.test.week_2;

/**
 * @author dongsen
 *         date: 2018/03/19 0019.
 *
 *         得分计算，给出一个O和X组成的随机字符串（长度为1-80），每个O得分为目前连续出现的O的个数，X得分为0.例如OOXXOXXOOO得分为：1+2+0+0+1+0+0+1+2+3
 */

public class OX {

    public static void main(String[] args) {
        String text = "OOXXOXXOOOOOO";

        int total = 0;
        int index = 1;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if ('O' == c){
                total +=index;
                index++;
            }else{
                index = 1;
            }
        }

        System.out.println(total);
    }

}
