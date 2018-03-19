package me.devilsen.test.week_2;

/**
 * @author dongsen
 *         date: 2018/03/19 0019.
 *         <p>
 *         分子量：给出一种物质的分子式，求分子量。分子式中只有4种原子 C，H，O，N）。原子量分别为12.01,1.008,16.00,14.01(单位 g/mol)。例如C6H5OH 的分子量为94.108g/mol
 */

public class MolecularWeight {

    public static void main(String[] args) {
        String text = "C6H5OH";

        double total = 0;

        char letter = '0';

        int num = 1;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c < 65) {
                num = c - 48 - 1;
            } else {
                letter = c;
                num = 1;
            }

            switch (letter) {
                case 'C':
                    total = 12.01 * num + total;
                    break;
                case 'H':
                    total = 1.008 * num + total;
                    break;
                case 'O':
                    total = 16.00 * num + total;
                    break;
                case 'N':
                    total = 14.01 * num + total;
                    break;
            }
        }

        System.out.println(total);
    }

}
